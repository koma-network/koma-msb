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

public class MsbOfflineWriteBean {

    private Integer rowid;
	private String subscriber;
	private String messageid;
	private String creationdate;
	private Integer messagesize;
	private String stanza;

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

	public String getMessageid() {
    	return this.messageid;
	}
  
	public void setMessageid(String messageid) {
    	this.messageid = messageid;
	}

	public String getCreationdate() {
    	return this.creationdate;
	}
  
	public void setCreationdate(String creationdate) {
    	this.creationdate = creationdate;
	}

	public Integer getMessagesize() {
    	return this.messagesize;
	}
  
	public void setMessagesize(Integer messagesize) {
    	this.messagesize = messagesize;
	}

	public String getStanza() {
    	return this.stanza;
	}
  
	public void setStanza(String stanza) {
    	this.stanza = stanza;
	}

}
