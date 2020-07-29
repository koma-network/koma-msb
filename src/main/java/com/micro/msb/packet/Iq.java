/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.micro.msb.packet;

/**
 *
 * @author SENOPATI
 */
public class Iq {

    private Bind bind;
    private Session session;
    private Query query;
    private VCard vCard;
    private Sharedgroup sharedgroup;
    private Error error;
    private Ping ping;
    private Attr attr;
    private String content;
    
    public Bind getBind() {
        return bind;
    }

    public void setBind(Bind bind) {
        this.bind = bind;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public VCard getvCard() {
        return vCard;
    }

    public void setvCard(VCard vCard) {
        this.vCard = vCard;
    }

    public Sharedgroup getSharedgroup() {
        return sharedgroup;
    }

    public void setSharedgroup(Sharedgroup sharedgroup) {
        this.sharedgroup = sharedgroup;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public Ping getPing() {
        return ping;
    }

    public void setPing(Ping ping) {
        this.ping = ping;
    }

    public Attr getAttr() {
        return attr;
    }

    public void setAttr(Attr attr) {
        this.attr = attr;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ClassPojo [bind = " + bind + ", attr = " + attr + "]";
    }
}
