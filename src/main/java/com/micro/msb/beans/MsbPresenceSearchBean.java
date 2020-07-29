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

public class MsbPresenceSearchBean {

    private Integer rowid;
	private String subscriber;
	private String offlinepresence;
	private String offlinedate;
	private java.util.List<MsbPresenceBean> msbPresence;

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

	public String getOfflinepresence() {
    	return this.offlinepresence;
	}
  
	public void setOfflinepresence(String offlinepresence) {
    	this.offlinepresence = offlinepresence;
	}

	public String getOfflinedate() {
    	return this.offlinedate;
	}
  
	public void setOfflinedate(String offlinedate) {
    	this.offlinedate = offlinedate;
	}

	public java.util.List<MsbPresenceBean> getMsbPresence() {
    	return this.msbPresence;
	}
  
	public void setMsbPresence(java.util.List<MsbPresenceBean> msbPresence) {
    	this.msbPresence = msbPresence;
	}

}
