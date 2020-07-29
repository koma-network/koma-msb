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

public class MsbAuthoritiesSearchBean {

    private Integer rowid;
	private String username;
	private String authority;
	private java.util.List<MsbAuthoritiesBean> msbAuthorities;

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

	public String getAuthority() {
    	return this.authority;
	}
  
	public void setAuthority(String authority) {
    	this.authority = authority;
	}

	public java.util.List<MsbAuthoritiesBean> getMsbAuthorities() {
    	return this.msbAuthorities;
	}
  
	public void setMsbAuthorities(java.util.List<MsbAuthoritiesBean> msbAuthorities) {
    	this.msbAuthorities = msbAuthorities;
	}

}
