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

public class MsbSubscriberReadBean {

    private Integer rowid;
	private String subscriber;
	private String password;
	private String name;
	private String email;
	private String creationdate;
	private String modificationdate;
	private String subtype;
	private String account;
	private String userkey;
	private java.util.List<MsbMucmemberBean> msbMucmember;
	private java.util.List<MsbOfflineBean> msbOffline;
	private java.util.List<MsbPresenceBean> msbPresence;
	private java.util.List<MsbRevenueBean> msbRevenue;
	private java.util.List<MsbRosterBean> msbRoster;
	private java.util.List<MsbSessionBean> msbSession;
	private java.util.List<MsbSubscriberpropBean> msbSubscriberprop;
	private java.util.List<MsbTrafficBean> msbTraffic;
	private java.util.List<MsbVcardBean> msbVcard;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getSubscriber() {
    	return this.subscriber;
	}
  
	public void setSubscriber(String subscriber) {
    	this.subscriber = subscriber;
	}

	public String getPassword() {
    	return this.password;
	}
  
	public void setPassword(String password) {
    	this.password = password;
	}

	public String getName() {
    	return this.name;
	}
  
	public void setName(String name) {
    	this.name = name;
	}

	public String getEmail() {
    	return this.email;
	}
  
	public void setEmail(String email) {
    	this.email = email;
	}

	public String getCreationdate() {
    	return this.creationdate;
	}
  
	public void setCreationdate(String creationdate) {
    	this.creationdate = creationdate;
	}

	public String getModificationdate() {
    	return this.modificationdate;
	}
  
	public void setModificationdate(String modificationdate) {
    	this.modificationdate = modificationdate;
	}

	public String getSubtype() {
    	return this.subtype;
	}
  
	public void setSubtype(String subtype) {
    	this.subtype = subtype;
	}

	public String getAccount() {
    	return this.account;
	}
  
	public void setAccount(String account) {
    	this.account = account;
	}

	public String getUserkey() {
    	return this.userkey;
	}
  
	public void setUserkey(String userkey) {
    	this.userkey = userkey;
	}

	public java.util.List<MsbMucmemberBean> getMsbMucmember() {
    	return this.msbMucmember;
	}
  
	public void setMsbMucmember(java.util.List<MsbMucmemberBean> msbMucmember) {
    	this.msbMucmember = msbMucmember;
	}

	public java.util.List<MsbOfflineBean> getMsbOffline() {
    	return this.msbOffline;
	}
  
	public void setMsbOffline(java.util.List<MsbOfflineBean> msbOffline) {
    	this.msbOffline = msbOffline;
	}

	public java.util.List<MsbPresenceBean> getMsbPresence() {
    	return this.msbPresence;
	}
  
	public void setMsbPresence(java.util.List<MsbPresenceBean> msbPresence) {
    	this.msbPresence = msbPresence;
	}

	public java.util.List<MsbRevenueBean> getMsbRevenue() {
    	return this.msbRevenue;
	}
  
	public void setMsbRevenue(java.util.List<MsbRevenueBean> msbRevenue) {
    	this.msbRevenue = msbRevenue;
	}

	public java.util.List<MsbRosterBean> getMsbRoster() {
    	return this.msbRoster;
	}
  
	public void setMsbRoster(java.util.List<MsbRosterBean> msbRoster) {
    	this.msbRoster = msbRoster;
	}

	public java.util.List<MsbSessionBean> getMsbSession() {
    	return this.msbSession;
	}
  
	public void setMsbSession(java.util.List<MsbSessionBean> msbSession) {
    	this.msbSession = msbSession;
	}

	public java.util.List<MsbSubscriberpropBean> getMsbSubscriberprop() {
    	return this.msbSubscriberprop;
	}
  
	public void setMsbSubscriberprop(java.util.List<MsbSubscriberpropBean> msbSubscriberprop) {
    	this.msbSubscriberprop = msbSubscriberprop;
	}

	public java.util.List<MsbTrafficBean> getMsbTraffic() {
    	return this.msbTraffic;
	}
  
	public void setMsbTraffic(java.util.List<MsbTrafficBean> msbTraffic) {
    	this.msbTraffic = msbTraffic;
	}

	public java.util.List<MsbVcardBean> getMsbVcard() {
    	return this.msbVcard;
	}
  
	public void setMsbVcard(java.util.List<MsbVcardBean> msbVcard) {
    	this.msbVcard = msbVcard;
	}

}
