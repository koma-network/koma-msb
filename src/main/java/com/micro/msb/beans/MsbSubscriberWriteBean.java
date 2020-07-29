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

public class MsbSubscriberWriteBean {

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

}
