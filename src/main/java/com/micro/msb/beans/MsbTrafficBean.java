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
public class MsbTrafficBean {

    private Integer rowid;
	private String subscriber;
	private String account;
	private String from;
	private String to;
	private Long counter;
	private String type;
	private java.util.Date lastUpdate;
	private String status;

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

	public String getAccount() {
    	return this.account;
	}
  
	public void setAccount(String account) {
    	this.account = account;
	}

	public String getFrom() {
    	return this.from;
	}
  
	public void setFrom(String from) {
    	this.from = from;
	}

	public String getTo() {
    	return this.to;
	}
  
	public void setTo(String to) {
    	this.to = to;
	}

	public Long getCounter() {
    	return this.counter;
	}
  
	public void setCounter(Long counter) {
    	this.counter = counter;
	}

	public String getType() {
    	return this.type;
	}
  
	public void setType(String type) {
    	this.type = type;
	}

	public java.util.Date getLastUpdate() {
    	return this.lastUpdate;
	}
  
	public void setLastUpdate(java.util.Date lastUpdate) {
    	this.lastUpdate = lastUpdate;
	}

	public String getStatus() {
    	return this.status;
	}
  
	public void setStatus(String status) {
    	this.status = status;
	}

}
