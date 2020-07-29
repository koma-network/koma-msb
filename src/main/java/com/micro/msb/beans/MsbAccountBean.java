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
public class MsbAccountBean {

    private Integer rowid;
	private String username;
	private String password;
	private String account;
	private String email;
	private String phone;
	private String mobile;
	private Integer enabled;
	private String token;

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

	public String getPassword() {
    	return this.password;
	}
  
	public void setPassword(String password) {
    	this.password = password;
	}

	public String getAccount() {
    	return this.account;
	}
  
	public void setAccount(String account) {
    	this.account = account;
	}

	public String getEmail() {
    	return this.email;
	}
  
	public void setEmail(String email) {
    	this.email = email;
	}

	public String getPhone() {
    	return this.phone;
	}
  
	public void setPhone(String phone) {
    	this.phone = phone;
	}

	public String getMobile() {
    	return this.mobile;
	}
  
	public void setMobile(String mobile) {
    	this.mobile = mobile;
	}

	public Integer getEnabled() {
    	return this.enabled;
	}
  
	public void setEnabled(Integer enabled) {
    	this.enabled = enabled;
	}

	public String getToken() {
    	return this.token;
	}
  
	public void setToken(String token) {
    	this.token = token;
	}

}
