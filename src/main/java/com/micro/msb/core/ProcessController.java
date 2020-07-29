/*
 * Copyright   : KOMA-Network (Indonesia IoT Club)
 * Create by   : Yan Yan Purdiansah
 * Create date : 21/06/2020
 * Link        : https://github.com/yypurdi/koma-msb-core
 * Description : This is the MSB Connector for Authentication & Control Inter Domain in KOMA Network
 *               This module is implemented in MicroSB side for Public/Private Environment
 */

package com.micro.msb.core;

import com.google.gson.Gson;
import com.micro.msb.beans.MsbMucroomBean;
import com.micro.msb.beans.MsbMucserviceReadBean;
import com.micro.msb.beans.MsbOfflineDeleteBean;
import com.micro.msb.beans.MsbOfflineNewBean;
import com.micro.msb.beans.MsbOfflineSearchBean;
import com.micro.msb.beans.MsbRosterBean;
import com.micro.msb.beans.MsbRosterDeleteBean;
import com.micro.msb.beans.MsbRosterNewBean;
import com.micro.msb.beans.MsbRosterWriteBean;
import com.micro.msb.beans.MsbSessionBean;
import com.micro.msb.beans.MsbSessionDeleteBean;
import com.micro.msb.beans.MsbSessionNewBean;
import com.micro.msb.beans.MsbSessionReadBean;
import com.micro.msb.beans.MsbSessionSearchBean;
import com.micro.msb.beans.MsbSessionWriteBean;
import com.micro.msb.beans.MsbSubscriberNewBean;
import com.micro.msb.beans.MsbSubscriberReadBean;
import com.micro.msb.dao.AuCDaoManager;
import org.springframework.beans.factory.annotation.Autowired;

import com.micro.msb.dao.DaoManager;
import com.micro.msb.packet.Attr;
import com.micro.msb.packet.Challenge;
import com.micro.msb.packet.Failure;
import com.micro.msb.packet.Item;
import com.micro.msb.packet.Packet;
import com.micro.msb.packet.Success;
import com.micro.msb.packet.Error;
import com.micro.msb.packet.Query;
import com.micro.msb.util.AuthFactory;
import com.micro.msb.util.Base64;
import com.micro.msb.util.Format;
import com.micro.msb.util.Helper;
import com.micro.msb.util.SASLMechanism;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

/**
 * Package : com.micro.msb.swagger for RestFull API Class :
 * SwaggerRestController
 *
 * @author : Yan Yan Purdiansah
 */
@Controller
public class ProcessController {

    private static final String FEATURE_INFO = "{'attr':{'xmlns':'http://jabber.org/protocol/disco#info'},'identity':[{'attr':{'category':'account','type':'registered'}},{'attr':{'category':'pubsub','type':'pep'}}],'feature':[{'attr':{'var':'http://jabber.org/protocol/disco#items'}},{'attr':{'var':'http://jabber.org/protocol/disco#info'}},{'attr':{'var':'http://jabber.org/protocol/pubsub'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-default'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#purge-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#subscribe'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#subscription-options'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#create-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#outcast-affiliation'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#get-pending'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#multi-subscribe'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#presence-notifications'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#delete-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#config-node'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#auto-create'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#item-ids'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#meta-data'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#instant-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#modify-affiliations'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#persistent-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#create-and-configure'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#publisher-affiliation'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#access-open'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-affiliations'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retract-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#manage-subscriptions'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#publish'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#collections'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-subscriptions'}},{'attr':{'var':'http://jabber.org/protocol/commands'}},{'attr':{'var':'http://jabber.org/protocol/offline'}},{'attr':{'var':'http://jabber.org/protocol/address'}},{'attr':{'var':'http://jabber.org/protocol/rsm'}},{'attr':{'var':'urn:xmpp:ping'}},{'attr':{'var':'jabber:iq:register'}},{'attr':{'var':'msgoffline'}},{'attr':{'var':'vcard-temp'}},{'attr':{'var':'jabber:iq:roster'}},{'attr':{'var':'jabber:iq:version'}},{'attr':{'var':'jabber:iq:private'}},{'attr':{'var':'urn:xmpp:time'}},{'attr':{'var':'jabber:iq:privacy'}},{'attr':{'var':'jabber:iq:last'}},{'attr':{'var':'urn:xmpp:carbons:2'}}]}";
    private static final String PROXY_INFO = "{'attr':{'xmlns':'http://jabber.org/protocol/disco#info'},'identity':{'attr':{'category':'proxy','name':'SOCKS5 Bytestreams Service','type':'bytestreams'}},'feature':[{'attr':{'var':'http://jabber.org/protocol/bytestreams'}},{'attr':{'var':'http://jabber.org/protocol/disco#info'}}]}";
    private static final String PUBSUB_INFO = "{'attr':{'xmlns':'http://jabber.org/protocol/disco#info'},'identity':{'attr':{'category':'pubsub','name':'Publish-Subscribe service','type':'service'}},'feature':[{'attr':{'var':'http://jabber.org/protocol/pubsub'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#access-open'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#collections'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#config-node'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#create-and-configure'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#create-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#delete-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#get-pending'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#instant-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#item-ids'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#meta-data'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#modify-affiliations'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#manage-subscriptions'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#multi-subscribe'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#outcast-affiliation'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#persistent-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#presence-notifications'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#publish'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#publisher-affiliation'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#purge-nodes'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retract-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-affiliations'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-default'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-items'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#retrieve-subscriptions'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#subscribe'}},{'attr':{'var':'http://jabber.org/protocol/pubsub#subscription-options'}},{'attr':{'var':'http://jabber.org/protocol/disco#info'}}]}";
    private static final String SEARCH_INFO = "{'attr':{'xmlns':'http://jabber.org/protocol/disco#info'},'identity':{'attr':{'category':'directory','type':'user','name':'User Search'}},'feature':[{'attr':{'var':'jabber:iq:search'}},{'attr':{'var':'http://jabber.org/protocol/disco#info'}},{'attr':{'var':'http://jabber.org/protocol/rsm'}}]}";
    private static final String SERVICE_INFO = "{'attr':{'xmlns':'http://jabber.org/protocol/disco#info'},'identity':[{'attr':{'category':'conference','name':'Public Chatrooms','type':'text'}},{'attr':{'category':'directory','name':'Public Chatroom Search','type':'chatroom'}}],'feature':[{'attr':{'var':'http://jabber.org/protocol/muc'}},{'attr':{'var':'http://jabber.org/protocol/disco#info'}},{'attr':{'var':'http://jabber.org/protocol/disco#items'}},{'attr':{'var':'jabber:iq:search'}},{'attr':{'var':'http://jabber.org/protocol/rsm'}}]}";
    private static final String REGISTER_FORM = "{'attr':{'xmlns':'jabber:iq:register'},'instructions':'Choose a username and password for use with this service.\\nPlease also provide your email address.','username':'','password':'','email':''}";
    
    @Value("${server.domain}")
    private String domain;
    @Value("${server.key}")
    private String serverKey;
    
    @Autowired
    private DaoManager dao;

    @Autowired
    private AuCDaoManager auc;
    
    public String encodeBlowFish(String password){
        return AuthFactory.encryptPassword(password,serverKey);
    }

    public String decodeBlowFish(String encryptedPassword){
        return AuthFactory.decryptPassword(encryptedPassword,serverKey);
    }
    
    public String authRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getAuth()!=null){            
            
            String sessionId = packet.getAuth().getAttr().getSession();
            String domain = packet.getAuth().getAttr().getDomain();
            
            SASLMechanism sasl = new SASLMechanism();
            byte[] chanllenge = sasl.getChallenge(domain);
            String base64Data = Base64.encodeBytes(chanllenge);
            
            Attr attr = new Attr();
            attr.setSession(sessionId);
            attr.setXmlns("urn:ietf:params:xml:ns:xmpp-sasl");
            
            Challenge challenge = new Challenge();
            challenge.setAttr(attr);
            challenge.setContent(base64Data);
            
            packet = new Packet();
            packet.setChallenge(challenge);
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String authRequestWebsocket(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getAuth()!=null){
            String sessionId = packet.getAuth().getAttr().getSession();
            String domain = packet.getAuth().getAttr().getDomain();
            String ip = packet.getAuth().getAttr().getIp();
            String port = packet.getAuth().getAttr().getPort();            
            String subscriber = packet.getAuth().getAttr().getFrom();
            if(subscriber.contains("@")) subscriber = subscriber.substring(0,subscriber.indexOf("@"));
            
            MsbSubscriberReadBean user = new MsbSubscriberReadBean();
            user.setSubscriber(subscriber);
            user = dao.readMsbSubscriber(user);

            String password = packet.getAuth().getContent();
            String passwordRef = AuthFactory.decryptPassword(user.getPassword(),serverKey);
            
            if(password.equalsIgnoreCase(passwordRef)){
                MsbSessionNewBean session = new MsbSessionNewBean();
                session.setSessionid(sessionId);
                session.setSubscriber(subscriber);
                session.setDomain(domain);
                session.setIpaddress(ip);
                session.setIpport(port);
                session.setProtocol("tcp");
                session.setStarttime(Format.formatFileDate());
                session.setPresence("unavailable");
                session.setStatus("Offline");
                dao.newMsbSession(session);

                Success success = new Success();
                Attr attr = packet.getAuth().getAttr();
                success.setAttr(attr);
                success.setContent(user.getPassword());
                packet = new Packet();
                packet.setSuccess(success);                    
            }
            else{
                Failure failure = new Failure();
                Attr attr = packet.getAuth().getAttr();
                failure.setAttr(attr);
                packet = new Packet();
                packet.setFailure(failure);
            }
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;        
    }
    
    public String responseRequest(String jsonIn) throws Exception {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getResponse()!=null){
            
            String sessionId = packet.getResponse().getAttr().getSession();
            String domain = packet.getResponse().getAttr().getDomain();
            String ip = packet.getResponse().getAttr().getIp();
            String port = packet.getResponse().getAttr().getPort();
            String content = packet.getResponse().getContent();            
            byte[] response = Base64.decode(content);
            
            SASLMechanism sasl = new SASLMechanism();
            MsbSubscriberReadBean user = new MsbSubscriberReadBean();
            String subscriber = sasl.getKeyValue(response, "username");
            user.setSubscriber(subscriber);
            user = dao.readMsbSubscriber(user);
            
            if(user!=null){
                String password = AuthFactory.decryptPassword(user.getPassword(), serverKey);
                String rspauth = "rspauth=" + sasl.createRspAuth(response,password);
                String rspauthBase64 = Base64.encodeBytes(rspauth.getBytes());

                String responseValue1 = sasl.getKeyValue(response, "response");
                String responseValue2 = sasl.calcResponse(response, password);
                
                if (responseValue1.equals(responseValue2)) {                
                    MsbSessionNewBean session = new MsbSessionNewBean();
                    session.setSessionid(sessionId);
                    session.setSubscriber(subscriber);
                    session.setDomain(domain);
                    session.setIpaddress(ip);
                    session.setIpport(port);
                    session.setProtocol("tcp");
                    session.setStarttime(Format.formatFileDate());
                    session.setPresence("unavailable");
                    session.setStatus("Offline");
                    dao.newMsbSession(session);

                    Attr attr = new Attr();
                    attr.setSession(sessionId);
                    attr.setXmlns("urn:ietf:params:xml:ns:xmpp-sasl");                
                    Success succes = new Success();
                    succes.setAttr(attr);
                    succes.setContent(rspauthBase64);
                    packet = new Packet();
                    packet.setSuccess(succes);
                }
                else{
                    Attr attr = new Attr();
                    attr.setSession(sessionId);
                    attr.setXmlns("urn:ietf:params:xml:ns:xmpp-sasl");                
                    Failure failure = new Failure();
                    failure.setAttr(attr);
                    failure.setContent("<not-authorized/>");
                    packet = new Packet();
                    packet.setFailure(failure);                       
                }
            }
            else{
                Attr attr = new Attr();
                attr.setSession(sessionId);
                attr.setXmlns("urn:ietf:params:xml:ns:xmpp-sasl");                
                Failure failure = new Failure();
                failure.setAttr(attr);
                failure.setContent("<not-authorized/>");
                packet = new Packet();
                packet.setFailure(failure);   
            }
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String bindRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq().getBind()!=null){
            
            String sessionId = packet.getIq().getAttr().getSession();
            String domain = packet.getIq().getAttr().getDomain();
            String resource = packet.getIq().getBind().getResource();
            
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            if(session!=null){
                MsbSessionWriteBean sessionwr = Helper.toMsbSessionWriteBean(session);
                sessionwr.setResource(resource);
                dao.writeMsbSession(sessionwr);
                packet.getIq().getBind().setJid(session.getSubscriber()+"@"+domain+"/"+resource);                
            }
            packet.getIq().getAttr().setType("result");
            packet.getIq().getBind().setResource(null);
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String sessionRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq().getSession()!=null){
            
            String sessionId = packet.getIq().getAttr().getSession();
            
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            if(session!=null){
                MsbSessionWriteBean sessionwr = Helper.toMsbSessionWriteBean(session);
                sessionwr.setPresence("available");
                sessionwr.setStatus("Online");
                dao.writeMsbSession(sessionwr);
            }
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }
    
    public String sharedgroupRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq().getSharedgroup()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.println(packet.getIq().getSharedgroup().getAttr().getXmlns());
            packet.getIq().getAttr().setTo(null);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String vcardRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq().getvCard()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.println(packet.getIq().getvCard().getAttr().getXmlns());
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String errorReport(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq().getError()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");            
            System.out.println("#->"+jsonIn);
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }
    
    public String getRosterRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null && packet.getIq().getAttr().getType().equalsIgnoreCase("get")){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.println(packet.getIq().getQuery().getAttr().getXmlns());
            
            String sessionId = packet.getIq().getAttr().getSession();
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            
            MsbSubscriberReadBean user = new MsbSubscriberReadBean();
            user.setSubscriber(session.getSubscriber());
            user = dao.readMsbSubscriber(user);
                        
            List<MsbRosterBean> rosters = user.getMsbRoster();
            Item[] items = new Item[rosters.size()];            
            for(int i=0;i<rosters.size();i++){
                MsbRosterBean roster = rosters.get(i);
                Attr attr = new Attr();
                attr.setJid(roster.getJid());
                attr.setName(roster.getNick());
                switch (roster.getSub()) {
                    case 0:
                        attr.setSubscription("none");
                        break;            
                    case 1:
                        attr.setSubscription("to");
                        break;
                    case 2:
                        attr.setSubscription("from");
                        break;
                    case 3:
                        attr.setSubscription("both");
                        break;
                    default:
                        break;
                }
                items[i] = new Item();                
                items[i].setAttr(attr);
                items[i].setGroup("Friends");                
            }
            packet.getIq().getQuery().setItem(items);
            packet.getIq().getAttr().setTo(null);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String setRosterRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        
        if(packet.getIq()!=null && packet.getIq().getAttr().getType().equalsIgnoreCase("set")){
            System.out.println("#->id : "+packet.getIq().getAttr().getId()+" ->"+packet.getIq().getQuery().getAttr().getXmlns());
            String sessionId = packet.getIq().getAttr().getSession();
            MsbSessionReadBean session = getSessionFrom(sessionId);
            
            if(session!=null){
                String to = packet.getIq().getQuery().getItem()[0].getAttr().getJid();
                String name = packet.getIq().getQuery().getItem()[0].getAttr().getName();
                String subscriber = to;
                if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));                
                String subscription = packet.getIq().getQuery().getItem()[0].getAttr().getSubscription();

                MsbSessionSearchBean rosterSession = new MsbSessionSearchBean();
                
                if(subscription!=null && subscription.equalsIgnoreCase("remove")){
                    
                    rosterSession.setSessionid(sessionId);
                    rosterSession.setSubscriber(subscriber);
                    rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
                    rosterSession.setSubscriber(session.getSubscriber());
                    
                    MsbRosterDeleteBean rosterTo = new MsbRosterDeleteBean();
                    rosterTo.setSubscriber(session.getSubscriber());
                    rosterTo.setJid(to);
                    dao.deleteMsbRoster(rosterTo);
                    
                    MsbRosterDeleteBean rosterFrom = new MsbRosterDeleteBean();
                    rosterFrom.setSubscriber(subscriber);
                    rosterFrom.setJid(session.getSubscriber()+"@"+session.getDomain());
                    dao.deleteMsbRoster(rosterFrom);                   
                }
                else{
                    rosterSession.setSessionid(sessionId);
                    rosterSession.setSubscriber(subscriber);
                    rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
                    
                    if(rosterSession.getMsbSession().isEmpty()){
                        System.out.println("###->Add Roster");
                        MsbRosterNewBean rosterTo = new MsbRosterNewBean();
                        rosterTo.setSubscriber(session.getSubscriber());
                        rosterTo.setJid(to);
                        rosterTo.setNick(name);
                        rosterTo.setSub(1);
                        rosterTo.setAsk(-1);
                        rosterTo.setRecv(-1);
                        dao.newMsbRoster(rosterTo);
                        
                        MsbRosterNewBean rosterFrom = new MsbRosterNewBean();
                        rosterFrom.setSubscriber(subscriber);
                        rosterFrom.setJid(session.getSubscriber()+"@"+session.getDomain());
                        rosterFrom.setNick(session.getSubscriber());
                        rosterFrom.setSub(2);
                        rosterFrom.setAsk(-1);
                        rosterFrom.setRecv(-1);
                        dao.newMsbRoster(rosterFrom);                        
                    }
                    else{
                        System.out.println("###->Update Roster");
                        MsbRosterWriteBean rosterTo = new MsbRosterWriteBean();
                        rosterTo.setSubscriber(session.getSubscriber());
                        rosterTo.setJid(to);
                        rosterTo.setNick(name);
                        rosterTo.setSub(3);
                        rosterTo.setAsk(-1);
                        rosterTo.setRecv(-1);
                        dao.writeMsbRoster(rosterTo);

                        MsbRosterWriteBean rosterFrom = new MsbRosterWriteBean();
                        rosterFrom.setSubscriber(subscriber);
                        rosterFrom.setJid(session.getSubscriber()+"@"+session.getDomain());
                        rosterFrom.setNick(session.getSubscriber());
                        rosterFrom.setSub(3);
                        rosterFrom.setAsk(-1);
                        rosterFrom.setRecv(-1);
                        dao.writeMsbRoster(rosterFrom);
                    }
                    
                    rosterSession.setSessionid(sessionId);
                    rosterSession.setSubscriber(subscriber);
                    rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
                    rosterSession.setSubscriber(session.getSubscriber());                    
                }
                return gson.toJson(rosterSession);
            }
        }
        return "";
    }
    
    public String registerRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);        
        if(packet.getIq().getAttr().getType().equalsIgnoreCase("get")){
            Query query = gson.fromJson(REGISTER_FORM,Query.class);
            packet.getIq().setQuery(query);
            packet.getIq().getAttr().setType("result");
        }
        if(packet.getIq().getAttr().getType().equalsIgnoreCase("set")){           
            if(packet.getIq().getQuery().getUsername()!=null){
                String username = packet.getIq().getQuery().getUsername();
                String password = packet.getIq().getQuery().getPassword();
                String encryptedPassword = AuthFactory.encryptPassword(password,serverKey);
                
                MsbSubscriberNewBean newSubscriber = new MsbSubscriberNewBean();
                newSubscriber.setSubscriber(username);
                newSubscriber.setPassword(encryptedPassword);
                newSubscriber.setName(username);
                newSubscriber.setEmail(username+"@"+domain);
                newSubscriber.setCreationdate(Format.formatFileDate());
                newSubscriber.setModificationdate(Format.formatFileDate());
                newSubscriber.setSubtype("device");
                try{
                    dao.newMsbSubscriber(newSubscriber);
                    System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
                    System.out.println(jsonIn);            
                    packet.getIq().getAttr().setTo(null);
                    packet.getIq().getAttr().setType("result");
                    
                }catch(Exception e){
                    Error error = createError();
                    packet.getIq().setError(error);                    
                    packet.getIq().getAttr().setTo(null);
                    packet.getIq().getAttr().setType("error");
                }
            }
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }
    
    public String discoItemsRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.print(packet.getIq().getQuery().getAttr().getXmlns()+" ->");
            String to = packet.getIq().getAttr().getTo();
            System.out.println("to: "+to);
            
            if(to!=null && to.equalsIgnoreCase(domain)){                
                Item[] items = new Item[4];
                String[] jids = {"proxy."+domain,"pubsub."+domain,"search."+domain,"province."+domain};
                String[] names = {"Socks 5 Bytestreams Proxy","Publish-Subscribe service","User Search","Conference"};
                for(int i=0;i<4;i++){
                    Attr attr = new Attr();
                    attr.setJid(jids[i]);
                    attr.setName(names[i]);
                    items[i] = new Item();                
                    items[i].setAttr(attr);
                }
                packet.getIq().getQuery().setItem(items);
                packet.getIq().getAttr().setTo(null);
                packet.getIq().getAttr().setFrom(domain);
            }
            else if(to!=null && to.contains("."+domain)){
                MsbMucserviceReadBean service = new MsbMucserviceReadBean();
                service.setServiceid(1L);
                service = dao.readMsbMucservice(service);
                List<MsbMucroomBean> rooms = service.getMsbMucroom();
                Item[] items = new Item[rooms.size()];
                for(int i=0;i<rooms.size();i++){
                    MsbMucroomBean room = rooms.get(i);
                    Attr attr = new Attr();
                    attr.setJid(room.getName()+"@"+to);
                    attr.setName(room.getNaturalname());
                    items[i] = new Item();                
                    items[i].setAttr(attr);
                }
                packet.getIq().getQuery().setItem(items);
                packet.getIq().getAttr().setTo(null);
                packet.getIq().getAttr().setFrom("province."+domain);                
            }            
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String discoInfoRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.print(packet.getIq().getQuery().getAttr().getXmlns());
            String to = packet.getIq().getAttr().getTo();
            System.out.println("->to: "+to);
            
            if(to.equalsIgnoreCase(domain)){
                Query query = gson.fromJson(FEATURE_INFO,Query.class);
                packet.getIq().setQuery(query);
            }
            else if(to.contains("proxy."+domain)) {
                Query query = gson.fromJson(PROXY_INFO,Query.class);
                packet.getIq().setQuery(query);                
            }
            else if(to.contains("pubsub."+domain)) {
                Query query = gson.fromJson(PUBSUB_INFO,Query.class);
                packet.getIq().setQuery(query);                
            }
            else if(to.contains("search."+domain)) {
                Query query = gson.fromJson(SEARCH_INFO,Query.class);
                packet.getIq().setQuery(query);                
            }
            else if(to.contains("province."+domain)) {
                Query query = gson.fromJson(SERVICE_INFO,Query.class);
                packet.getIq().setQuery(query);                
            }
            else{
                System.out.println("->to: "+to);
            }
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String privateRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.println(packet.getIq().getQuery().getAttr().getXmlns());
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String lastRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");
            System.out.print(packet.getIq().getQuery().getAttr().getXmlns()+" ->");
            System.out.println(packet.getIq().getAttr().getTo());
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
            packet.getIq().getQuery().getAttr().setSeconds("-1");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }
    
    public String queryRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");            
            System.out.println(jsonIn);
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }
    
    public String iqRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            System.out.print("#->id : "+packet.getIq().getAttr().getId()+" ->");            
            System.out.println(jsonIn);
            String from = packet.getIq().getAttr().getFrom();
            String to = packet.getIq().getAttr().getTo();
            packet.getIq().getAttr().setTo(from);
            packet.getIq().getAttr().setFrom(to);
            packet.getIq().getAttr().setType("result");
        }
        String jsonOut = gson.toJson(packet);
        return jsonOut;
    }

    public String iqForward(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getIq()!=null){
            String sessionId = packet.getIq().getAttr().getSession();            
            String to = packet.getIq().getAttr().getTo();
            String subscriber = to;
            if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));
            MsbSessionBean msbSessionBean = getSessionTo(sessionId,subscriber);
            
            if(msbSessionBean!=null){
                if(msbSessionBean.getPresence().equalsIgnoreCase("available")){
                    String sessionIdTo = msbSessionBean.getSessionid();
                    packet.getIq().getAttr().setSession(sessionIdTo);
                    return gson.toJson(packet);
                }
            }
        }
        return "";
    }
    
    public String subscribeRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            String sessionId = packet.getPresence().getAttr().getSession();            
            MsbSessionReadBean session = getSessionFrom(sessionId);
            String to = packet.getPresence().getAttr().getTo();
            String subscriber = to;
            if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));            
            MsbSessionSearchBean rosterSession = new MsbSessionSearchBean();
            rosterSession.setSessionid(sessionId);
            rosterSession.setSubscriber(subscriber);
            rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
            rosterSession.setSubscriber(session.getSubscriber());            
            return gson.toJson(rosterSession);
        }
        return "";
    }

    public String subscribedRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            String sessionId = packet.getPresence().getAttr().getSession();            
            MsbSessionReadBean session = getSessionFrom(sessionId);
            String to = packet.getPresence().getAttr().getTo();
            String subscriber = to;
            if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));            
            MsbSessionSearchBean rosterSession = new MsbSessionSearchBean();
            rosterSession.setSessionid(sessionId);
            rosterSession.setSubscriber(subscriber);
            rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
            rosterSession.setSubscriber(session.getSubscriber());            
            return gson.toJson(rosterSession);            
        }
        return "";
    }

    public String unsubscribeRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            String sessionId = packet.getPresence().getAttr().getSession();            
            MsbSessionReadBean session = getSessionFrom(sessionId);
            String from = session.getSubscriber()+"@"+session.getDomain();
            String to = packet.getPresence().getAttr().getTo();
            String subscriber = to;
            if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));            

            MsbSessionSearchBean rosterSession = new MsbSessionSearchBean();
            rosterSession.setSessionid(sessionId);
            rosterSession.setSubscriber(subscriber);
            rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
            rosterSession.setSubscriber(session.getSubscriber());            
            
            MsbRosterDeleteBean rosterTo = new MsbRosterDeleteBean();
            rosterTo.setSubscriber(session.getSubscriber());
            rosterTo.setJid(to);
            dao.deleteMsbRoster(rosterTo);

            MsbRosterDeleteBean rosterFrom = new MsbRosterDeleteBean();
            rosterFrom.setSubscriber(subscriber);
            rosterFrom.setJid(from);
            dao.deleteMsbRoster(rosterFrom);                   
            
            return gson.toJson(rosterSession);            
        }
        return "";
    }
    
    public String unsubscribedRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            String sessionId = packet.getPresence().getAttr().getSession();            
            MsbSessionReadBean session = getSessionFrom(sessionId);
            String from = session.getSubscriber()+"@"+session.getDomain();
            String to = packet.getPresence().getAttr().getTo();
            String subscriber = to;
            if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));            

            MsbSessionSearchBean rosterSession = new MsbSessionSearchBean();
            rosterSession.setSessionid(sessionId);
            rosterSession.setSubscriber(subscriber);
            rosterSession = auc.searchMsbSessionRosterSubscriber(rosterSession);
            rosterSession.setSubscriber(session.getSubscriber());            
           
            MsbRosterDeleteBean rosterTo = new MsbRosterDeleteBean();
            rosterTo.setSubscriber(session.getSubscriber());
            rosterTo.setJid(to);
            dao.deleteMsbRoster(rosterTo);

            MsbRosterDeleteBean rosterFrom = new MsbRosterDeleteBean();
            rosterFrom.setSubscriber(subscriber);
            rosterFrom.setJid(from);
            dao.deleteMsbRoster(rosterFrom);                   
            
            return gson.toJson(rosterSession);            
        }
        return "";
    }
    
    public String presenceRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            
            String sessionId = packet.getPresence().getAttr().getSession();
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            
            if(session!=null && packet.getPresence()!=null){
                if(packet.getPresence().getAttr().getType()!=null){
                    if(packet.getPresence().getAttr().getType().equalsIgnoreCase("unavailable")){
                        System.out.println("#->id : "+packet.getPresence().getAttr().getId()+" ->Unavailable("+packet.getPresence().getAttr().getSession()+")");
                        /*
                         * Update last Session Record
                         */
                        MsbSessionWriteBean sessionwr = Helper.toMsbSessionWriteBean(session);
                        sessionwr.setPresence("unavailable");
                        sessionwr.setStatus("Offline");
                        sessionwr.setEndtime(Format.formatFileDate());
                        dao.writeMsbSession(sessionwr);

                        /*
                         * Delete Old Session Records 
                         */
                        MsbSessionDeleteBean deleteRecord = new MsbSessionDeleteBean();
                        deleteRecord.setSessionid(sessionId);
                        deleteRecord.setSubscriber(session.getSubscriber());
                        auc.deleteMsbSessionOldRecords(deleteRecord);                    
                    }
                    else{
                        System.out.println("#->id : "+packet.getPresence().getAttr().getId()+" ->Presence("+packet.getPresence().getAttr().getSession()+")");                
                        MsbSessionWriteBean sessionwr = Helper.toMsbSessionWriteBean(session);
                        sessionwr.setPresence("available");
                        if(packet.getPresence().getShow()!=null)
                            sessionwr.setStatus(packet.getPresence().getShow());
                        else
                            sessionwr.setStatus("Online");
                        dao.writeMsbSession(sessionwr);
                    }                    
                }
                else{
                    System.out.println("#->id : "+packet.getPresence().getAttr().getId()+" ->Presence("+packet.getPresence().getAttr().getSession()+")");                
                    MsbSessionWriteBean sessionwr = Helper.toMsbSessionWriteBean(session);
                    sessionwr.setPresence("available");
                    if(packet.getPresence().getShow()!=null)
                        sessionwr.setStatus(packet.getPresence().getShow());
                    else
                        sessionwr.setStatus("Online");
                    dao.writeMsbSession(sessionwr);
                }
                /*
                 * Return the list of roster online
                 */
                MsbSessionSearchBean rosterOnline = new MsbSessionSearchBean();
                rosterOnline.setSessionid(sessionId);
                rosterOnline.setSubscriber(session.getSubscriber());
                rosterOnline.setDomain(session.getDomain());
                rosterOnline = auc.searchMsbSessionRosterOnline(rosterOnline);
                return gson.toJson(rosterOnline);                
            }
        }
        return "";
    }

    public String offlineMessageRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        if(packet.getPresence()!=null){
            String sessionId = packet.getPresence().getAttr().getSession();
            MsbSessionReadBean session = new MsbSessionReadBean();
            session.setSessionid(sessionId);
            session = dao.readMsbSession(session);
            
            if(session!=null){
                MsbOfflineSearchBean offlineMsg = new MsbOfflineSearchBean();
                offlineMsg.setSubscriber(session.getSubscriber());
                offlineMsg.setRowid(0);
                offlineMsg = dao.searchMsbOffline(offlineMsg);
                
                MsbOfflineDeleteBean deleteMsg = new MsbOfflineDeleteBean();
                deleteMsg.setSubscriber(session.getSubscriber());
                dao.deleteMsbOffline(deleteMsg);                
                return gson.toJson(offlineMsg);
            }
        }
        return "";
    }

    public String messageRequest(String jsonIn) {
        Gson gson = new Gson();
        Packet packet = gson.fromJson(jsonIn,Packet.class);
        
        if(packet.getMessage()!=null){
            System.out.println("#->id : "+packet.getMessage().getAttr().getId()+" ->Message to: "+packet.getMessage().getAttr().getTo());
            String sessionId = packet.getMessage().getAttr().getSession();            
            MsbSessionReadBean session = getSessionFrom(sessionId);
            
            if(session!=null){
                String from = session.getSubscriber()+"@"+session.getDomain();
                String to = packet.getMessage().getAttr().getTo();
                String subscriber = to;
                if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));                
                MsbSessionBean msbSessionBean = getSessionTo(sessionId,subscriber);
                
                if(msbSessionBean!=null){
                    if(msbSessionBean.getPresence().equalsIgnoreCase("available")){
                        String sessionIdRoster = msbSessionBean.getSessionid();
                        packet.getMessage().getAttr().setSession(sessionIdRoster);
                        packet.getMessage().getAttr().setFrom(from);
                        packet.getMessage().getAttr().setTo(to+"/"+msbSessionBean.getResource());
                        return gson.toJson(packet);
                    }
                    else{                        
                        if(packet.getMessage().getBody()!=null){
                            packet.getMessage().getAttr().setFrom(from);
                            saveMessageOffline(packet);
                        }
                    }
                }
                else{   
                    if(packet.getMessage().getBody()!=null){
                        packet.getMessage().getAttr().setFrom(from);
                        saveMessageOffline(packet);
                    }
                }
            }
        }
        return "";
    }
    
    private Error createError(){
        Attr attr = new Attr();
        attr.setType("cancel");
        attr.setCode("405");
        Error error = new Error();
        error.setAttr(attr);
        error.setContent("<not-acceptable xmlns='urn:ietf:params:xml:ns:xmpp-stanzas'/>");
        return error;
    }
    
    private MsbSessionReadBean getSessionFrom(String sessionId){
        MsbSessionReadBean session = new MsbSessionReadBean();
        session.setSessionid(sessionId);
        session = dao.readMsbSession(session);
        return session;
    }    
    
    private MsbSessionBean getSessionTo(String sessionId,String subscriberTo){
        MsbSessionSearchBean rosterOnline = new MsbSessionSearchBean();
        rosterOnline.setSessionid(sessionId);
        rosterOnline.setSubscriber(subscriberTo);
        rosterOnline = auc.searchMsbSessionRosterSubscriber(rosterOnline);
        List<MsbSessionBean> list = rosterOnline.getMsbSession();
        if(list.size()>0){
            MsbSessionBean msbSessionBean = list.get(0);
            return msbSessionBean;
        }else return null;        
    }
    
    private void saveMessageOffline(Packet packet){
        Gson gson = new Gson();
        String json = gson.toJson(packet);
        String to = packet.getMessage().getAttr().getTo();
        String subscriber = to;
        if(to.contains("@")) subscriber = to.substring(0,to.indexOf("@"));
        
        MsbOfflineNewBean msgOffline = new MsbOfflineNewBean();
        msgOffline.setSubscriber(subscriber);
        msgOffline.setMessageid(packet.getMessage().getAttr().getId());
        msgOffline.setMessagesize(json.length());
        msgOffline.setCreationdate(Format.formatFileDate());
        msgOffline.setStanza(json);
        dao.newMsbOffline(msgOffline);                                
    }
}
