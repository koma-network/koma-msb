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
public class MsbSessionBean {

    private Integer rowid;
	private String sessionid;
	private String subscriber;
	private String domain;
	private String ipaddress;
	private String ipport;
	private String protocol;
	private String starttime;
	private String endtime;
	private String resource;
	private String presence;
	private String status;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getSessionid() {
    	return this.sessionid;
	}
  
	public void setSessionid(String sessionid) {
    	this.sessionid = sessionid;
	}

	public String getSubscriber() {
    	return this.subscriber;
	}
  
	public void setSubscriber(String subscriber) {
    	this.subscriber = subscriber;
	}

	public String getDomain() {
    	return this.domain;
	}
  
	public void setDomain(String domain) {
    	this.domain = domain;
	}

	public String getIpaddress() {
    	return this.ipaddress;
	}
  
	public void setIpaddress(String ipaddress) {
    	this.ipaddress = ipaddress;
	}

	public String getIpport() {
    	return this.ipport;
	}
  
	public void setIpport(String ipport) {
    	this.ipport = ipport;
	}

	public String getProtocol() {
    	return this.protocol;
	}
  
	public void setProtocol(String protocol) {
    	this.protocol = protocol;
	}

	public String getStarttime() {
    	return this.starttime;
	}
  
	public void setStarttime(String starttime) {
    	this.starttime = starttime;
	}

	public String getEndtime() {
    	return this.endtime;
	}
  
	public void setEndtime(String endtime) {
    	this.endtime = endtime;
	}

	public String getResource() {
    	return this.resource;
	}
  
	public void setResource(String resource) {
    	this.resource = resource;
	}

	public String getPresence() {
    	return this.presence;
	}
  
	public void setPresence(String presence) {
    	this.presence = presence;
	}

	public String getStatus() {
    	return this.status;
	}
  
	public void setStatus(String status) {
    	this.status = status;
	}

}
