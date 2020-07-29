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

public class MsbAccountReadBean {

    private Integer rowid;
	private String username;
	private String password;
	private String account;
	private String email;
	private String phone;
	private String mobile;
	private Integer enabled;
	private String token;
	private java.util.List<MsbAuthoritiesBean> msbAuthorities;
	private java.util.List<MsbPersistentLoginsBean> msbPersistentLogins;
	private java.util.List<MsbSubscriberBean> msbSubscriber;

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

	public java.util.List<MsbAuthoritiesBean> getMsbAuthorities() {
    	return this.msbAuthorities;
	}
  
	public void setMsbAuthorities(java.util.List<MsbAuthoritiesBean> msbAuthorities) {
    	this.msbAuthorities = msbAuthorities;
	}

	public java.util.List<MsbPersistentLoginsBean> getMsbPersistentLogins() {
    	return this.msbPersistentLogins;
	}
  
	public void setMsbPersistentLogins(java.util.List<MsbPersistentLoginsBean> msbPersistentLogins) {
    	this.msbPersistentLogins = msbPersistentLogins;
	}

	public java.util.List<MsbSubscriberBean> getMsbSubscriber() {
    	return this.msbSubscriber;
	}
  
	public void setMsbSubscriber(java.util.List<MsbSubscriberBean> msbSubscriber) {
    	this.msbSubscriber = msbSubscriber;
	}

}
