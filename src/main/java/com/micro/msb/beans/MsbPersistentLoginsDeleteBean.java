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

public class MsbPersistentLoginsDeleteBean {

    private Integer rowid;
	private String username;
	private String series;
	private String token;
	private java.util.Date lastUsed;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getUsername() {
    	return this.username;
	}
  
	public void setUsername(String username) {
    	this.username = username;
	}

	public String getSeries() {
    	return this.series;
	}
  
	public void setSeries(String series) {
    	this.series = series;
	}

	public String getToken() {
    	return this.token;
	}
  
	public void setToken(String token) {
    	this.token = token;
	}

	public java.util.Date getLastUsed() {
    	return this.lastUsed;
	}
  
	public void setLastUsed(java.util.Date lastUsed) {
    	this.lastUsed = lastUsed;
	}

}
