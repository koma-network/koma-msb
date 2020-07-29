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

public class MsbRemoteserverDeleteBean {

    private Integer rowid;
	private String xmppdomain;
	private String remoteaddress;
	private Integer remoteport;
	private String user;
	private String password;
	private String permission;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getXmppdomain() {
    	return this.xmppdomain;
	}
  
	public void setXmppdomain(String xmppdomain) {
    	this.xmppdomain = xmppdomain;
	}

	public String getRemoteaddress() {
    	return this.remoteaddress;
	}
  
	public void setRemoteaddress(String remoteaddress) {
    	this.remoteaddress = remoteaddress;
	}

	public Integer getRemoteport() {
    	return this.remoteport;
	}
  
	public void setRemoteport(Integer remoteport) {
    	this.remoteport = remoteport;
	}

	public String getUser() {
    	return this.user;
	}
  
	public void setUser(String user) {
    	this.user = user;
	}

	public String getPassword() {
    	return this.password;
	}
  
	public void setPassword(String password) {
    	this.password = password;
	}

	public String getPermission() {
    	return this.permission;
	}
  
	public void setPermission(String permission) {
    	this.permission = permission;
	}

}
