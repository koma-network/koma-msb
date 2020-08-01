/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/yypurdi/koma-msb-core
 * Description : This is the MSB Connector for Authentication & Control Inter Domain in KOMA Network
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

package com.micro.msb.core;

import com.micro.msb.beans.MsbSessionReadBean;
import com.micro.msb.dao.DaoManager;
import com.micro.msb.util.AppContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

public class ProcessThread extends Thread {

    private static final Logger LOG = LoggerFactory.getLogger(ProcessThread.class);

    private ZMQ.Context context;
    private ZMQ.Socket receiver;
    private ZMQ.Socket sender;
    private ZMQ.Socket proxy;

    private String tcpConnectRep;
    private String tcpConnectPush;

    private final DaoManager dao;
    private final ProcessController ctrl;
    
    public ProcessThread(){
        dao = (DaoManager) AppContext.getApplicationContext().getBean("daoManager");
        ctrl = (ProcessController) AppContext.getApplicationContext().getBean("processController");
    }
    
    public void setTcpConnectRep(String tcpConnectRep) {
        this.tcpConnectRep = tcpConnectRep;
    }

    public void setTcpConnectPush(String tcpConnectPush) {
        this.tcpConnectPush = tcpConnectPush;
    }

    public void initiate() {
        
        context = ZMQ.context(1);
        receiver = context.socket(ZMQ.REP);
        sender = context.socket(ZMQ.PUSH);

        receiver.connect(tcpConnectRep);
        sender.connect(tcpConnectPush);
    }
    
    public void sendJson(String patern, String xml) {
        try {
            sender.send(patern + ":&:%:#:" + xml);
        } catch (Exception e) {
            LOG.error(e.getMessage());
        }
    }

    @Override
    public void run() {

        LOG.info("Initiate Process Thread...");

        initiate();

        while (!Thread.currentThread().isInterrupted()) {
            String json = new String(receiver.recv(0));
            receiver.send("OK".getBytes(), 0);
            try {
                JSONObject jsonObj = new JSONObject(json);
                
                if (jsonObj.has("stream:stream")){
                    LOG.debug(jsonObj.toString());
                    onOpenSession(jsonObj);                    
                }
                else if (jsonObj.has("stream:features")) {
                    LOG.debug(jsonObj.toString());
                }                
                else if (jsonObj.has("auth")) {
                    LOG.debug(jsonObj.toString());
                    String sessionId = getSessionId(jsonObj,"auth");
                    String jsonOut = ctrl.authRequest(json);
                    sender.send(sessionId + ":&:%:#:" + jsonOut);
                }                
                else if (jsonObj.has("response")) {
                    LOG.debug(jsonObj.toString());
                    String sessionId = getSessionId(jsonObj,"response");
                    String jsonOut = ctrl.responseRequest(json);
                    sender.send(sessionId + ":&:%:#:" + jsonOut);
                }                
                else if (jsonObj.has("iq")) {
                    LOG.debug(jsonObj.toString());
                    onIQ(jsonObj);
                } else if (jsonObj.has("presence")) {
                    LOG.debug(jsonObj.toString());
                    onPresence(jsonObj);
                } else if (jsonObj.has("message")) {
                    LOG.debug(jsonObj.toString());
                    onMessage(jsonObj);
                } else {
                    LOG.info(jsonObj.toString());
                    onRequest(jsonObj);
                }

            } catch (Exception e) {
                LOG.error(e.getMessage());
            }
        }

        receiver.close();
        sender.close();
        proxy.close();
        context.term();
    }

    private String getSessionId(JSONObject jsonObj,String tag){
        String sessionId = jsonObj.getJSONObject(tag).getJSONObject("attr").getString("session");
        return sessionId;
    }

    private void sendJSON(String jsonOut,String tag){
        JSONObject jsonObj = new JSONObject(jsonOut);
        String sessionId = getSessionId(jsonObj,tag);
        jsonObj.getJSONObject(tag).getJSONObject("attr").remove("session");
        jsonObj.getJSONObject(tag).getJSONObject("attr").remove("domain");
        jsonObj.getJSONObject(tag).getJSONObject("attr").remove("ip");
        jsonObj.getJSONObject(tag).getJSONObject("attr").remove("port");
        sender.send(sessionId + ":&:%:#:" + jsonObj.toString());
    }
    
    /*
     * Open Stream Session Processing
     */    
    private void onOpenSession(JSONObject jsonObj){
        
        try{
            String sessionId = getSessionId(jsonObj,"stream:stream");
            jsonObj.getJSONObject("stream:stream").getJSONObject("attr").put("id",sessionId);
            jsonObj.getJSONObject("stream:stream").getJSONObject("attr").put("xmlns","jabber:server");
            jsonObj.getJSONObject("stream:stream").getJSONObject("attr").put("from","domain.com");
            jsonObj.getJSONObject("stream:stream").getJSONObject("attr").remove("to");
            sendJSON(jsonObj.toString(),"stream:stream");
            
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            
            if(session==null){            
                String features1 = "{\"stream:features\":{\"mechanisms\":{\"attr\":{\"xmlns\":\"urn:ietf:params:xml:ns:xmpp-sasl\"},\"mechanism\":[\"PLAIN\",\"DIGEST-MD5\"]},\"compression\":{\"attr\":{\"xmlns\":\"http://jabber.org/features/compress\"},\"method\":\"zlib\"},\"auth\":{\"attr\":{\"xmlns\":\"http://jabber.org/features/iq-auth\"}},\"register\":{\"attr\":{\"xmlns\":\"http://jabber.org/features/iq-register\"}}}}";
                sender.send(sessionId + ":&:%:#:" + features1);
            }
            else{
                String features2 = "{\"stream:features\":{\"compression\":{\"attr\":{\"xmlns\":\"http://jabber.org/features/compress\"},\"method\":\"zlib\"},\"bind\":{\"attr\":{\"xmlns\":\"urn:ietf:params:xml:ns:xmpp-bind\"}},\"session\":{\"attr\":{\"xmlns\":\"urn:ietf:params:xml:ns:xmpp-session\"},\"optional\":\"\"},\"sm\":[{\"attr\":{\"xmlns\":\"urn:xmpp:sm:2\"}},{\"attr\":{\"xmlns\":\"urn:xmpp:sm:3\"}}]}}";
                sender.send(sessionId + ":&:%:#:" + features2);
            }
        }catch(JSONException e){
            LOG.error(e.getMessage());
        }        
    }

    /*
     * InQuery Processing
     */    
    private void onIQ(JSONObject jsonObj) {
        
        if (jsonObj.getJSONObject("iq").has("bind")) {            
            String jsonOut = ctrl.bindRequest(jsonObj.toString());
            sendJSON(jsonOut,"iq");
        }
        else if (jsonObj.getJSONObject("iq").has("session")) {
            String jsonOut = ctrl.sessionRequest(jsonObj.toString());
            sendJSON(jsonOut,"iq");
        }        
        else if (jsonObj.getJSONObject("iq").has("sharedgroup")) {
            String jsonOut = ctrl.sharedgroupRequest(jsonObj.toString());
            sendJSON(jsonOut,"iq");
        }        
        else if (jsonObj.getJSONObject("iq").has("vCard")) {
            String jsonOut = ctrl.vcardRequest(jsonObj.toString());
            sendJSON(jsonOut,"iq");
        }        
        else if (jsonObj.getJSONObject("iq").has("error")) {
            String jsonOut = ctrl.errorReport(jsonObj.toString());
            sendJSON(jsonOut,"iq");
        }        
        else if (jsonObj.getJSONObject("iq").has("ping")) {
            jsonObj.getJSONObject("iq").getJSONObject("attr").put("type","result");
            sendJSON(jsonObj.toString(),"iq");
        }        
        else if (jsonObj.getJSONObject("iq").has("query")) {
            
            String type = jsonObj.getJSONObject("iq").getJSONObject("attr").getString("type");
            String xmlns = jsonObj.getJSONObject("iq").getJSONObject("query").getJSONObject("attr").getString("xmlns");

            if(xmlns.equalsIgnoreCase("jabber:iq:register")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.registerRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }            
            else if(xmlns.equalsIgnoreCase("jabber:iq:roster")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.getRosterRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }
            else if(xmlns.equalsIgnoreCase("http://jabber.org/protocol/disco#items")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.discoItemsRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }
            else if(xmlns.equalsIgnoreCase("http://jabber.org/protocol/disco#info")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.discoInfoRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }            
            else if(xmlns.equalsIgnoreCase("jabber:iq:private")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.privateRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }            
            else if(xmlns.equalsIgnoreCase("jabber:iq:last")){
                if(type.equalsIgnoreCase("get")){
                    String jsonOut = ctrl.privateRequest(jsonObj.toString());
                    sendJSON(jsonOut,"iq");
                }
            }
            else {
                String jsonOut = ctrl.queryRequest(jsonObj.toString());
                sendJSON(jsonOut,"iq");
            }
        }        
    }

    /*
     * Presence Processing
     */
    private void onPresence(JSONObject jsonObj) {
        
        String sessionId = getSessionId(jsonObj,"presence");
        String type = null;
        if(jsonObj.getJSONObject("presence").getJSONObject("attr").has("type")){
            type = jsonObj.getJSONObject("presence").getJSONObject("attr").getString("type");
        }
        if(type!=null && type.equalsIgnoreCase("subscribe")){
            String jsonOut = ctrl.subscribeRequest(jsonObj.toString());
            sendJSON(jsonOut,"presence");
        }
        else if(type!=null && type.equalsIgnoreCase("subscribed")){
            String jsonOut = ctrl.subscribedRequest(jsonObj.toString());
            sendJSON(jsonOut,"presence");
        }        
        else if(type!=null && type.equalsIgnoreCase("unsubscribeRequest")){
            String jsonOut = ctrl.subscribedRequest(jsonObj.toString());
            sendJSON(jsonOut,"presence");
        }        
        else if(type!=null && type.equalsIgnoreCase("unsubscribed")){
            String jsonOut = ctrl.unsubscribedRequest(jsonObj.toString());
            sendJSON(jsonOut,"presence");
        }                
        else {
            /*
             * Checking all online rosters
             */
            String jsonOut = ctrl.presenceRequest(jsonObj.toString());
            JSONObject jsonObjOut = new JSONObject(jsonOut);
            JSONArray rosters = jsonObjOut.getJSONArray("msbSession");
            int length = rosters.length();
            for(int i=0;i<length;i++){
                /*
                 * For Receiver
                 */
                JSONObject roster = rosters.getJSONObject(i);
                String rosterSessionId = roster.getString("sessionid");
                //String to = roster.getString("subscriber")+"@"+roster.getString("domain")+"/"+roster.getString("resource");
                String to = roster.getString("subscriber")+"@"+roster.getString("domain");
                String from = jsonObjOut.getString("subscriber")+"@"+jsonObjOut.getString("domain");
                jsonObj.getJSONObject("presence").getJSONObject("attr").put("session",rosterSessionId);
                jsonObj.getJSONObject("presence").getJSONObject("attr").put("to",to);
                jsonObj.getJSONObject("presence").getJSONObject("attr").put("from",from);                
                sendJSON(jsonObj.toString(),"presence");
                LOG.debug(jsonObj.toString());

                /*
                 * For Sender
                 */
                if(type==null){
                    //from = roster.getString("subscriber")+"@"+roster.getString("domain")+"/"+roster.getString("resource");
                    from = roster.getString("subscriber")+"@"+roster.getString("domain");
                    to = jsonObjOut.getString("subscriber")+"@"+jsonObjOut.getString("domain");
                    String status = roster.getString("status");
                    jsonObj.getJSONObject("presence").getJSONObject("attr").put("session",sessionId);
                    jsonObj.getJSONObject("presence").getJSONObject("attr").put("to",to);
                    jsonObj.getJSONObject("presence").getJSONObject("attr").put("from",from);
                    jsonObj.getJSONObject("presence").getJSONObject("attr").put("status",status);                    
                    sendJSON(jsonObj.toString(),"presence");
                    LOG.debug(jsonObj.toString());
                }
            }                                        
        }        
    }

    /*
     * Message Processing
     */    
    private void onMessage(JSONObject jsonObj) {
        String jsonOut = ctrl.messageRequest(jsonObj.toString());
        sendJSON(jsonOut,"message");
    }

    /*
     * Other or Unknown Request Processing
     */    
    private void onRequest(JSONObject jsonObj) {
        
    }
}
