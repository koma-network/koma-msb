/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.micro.msb.beans;

/*
 *
 * @author Yan Yan Purdiansah
 */

public class MsbRosterReadBean {

    private Integer rowid;
	private Long rosterid;
	private String subscriber;
	private String jid;
	private Integer sub;
	private Integer ask;
	private Integer recv;
	private String nick;
	private String key;
	private java.util.List<MsbRostergroupsBean> msbRostergroups;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public Long getRosterid() {
    	return this.rosterid;
	}
  
	public void setRosterid(Long rosterid) {
    	this.rosterid = rosterid;
	}

	public String getSubscriber() {
    	return this.subscriber;
	}
  
	public void setSubscriber(String subscriber) {
    	this.subscriber = subscriber;
	}

	public String getJid() {
    	return this.jid;
	}
  
	public void setJid(String jid) {
    	this.jid = jid;
	}

	public Integer getSub() {
    	return this.sub;
	}
  
	public void setSub(Integer sub) {
    	this.sub = sub;
	}

	public Integer getAsk() {
    	return this.ask;
	}
  
	public void setAsk(Integer ask) {
    	this.ask = ask;
	}

	public Integer getRecv() {
    	return this.recv;
	}
  
	public void setRecv(Integer recv) {
    	this.recv = recv;
	}

	public String getNick() {
    	return this.nick;
	}
  
	public void setNick(String nick) {
    	this.nick = nick;
	}

	public String getKey() {
    	return this.key;
	}
  
	public void setKey(String key) {
    	this.key = key;
	}

	public java.util.List<MsbRostergroupsBean> getMsbRostergroups() {
    	return this.msbRostergroups;
	}
  
	public void setMsbRostergroups(java.util.List<MsbRostergroupsBean> msbRostergroups) {
    	this.msbRostergroups = msbRostergroups;
	}

}
