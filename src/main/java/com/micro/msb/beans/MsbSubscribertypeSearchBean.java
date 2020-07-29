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

public class MsbSubscribertypeSearchBean {

    private Integer rowid;
	private String subtype;
	private String description;
	private java.util.List<MsbSubscribertypeBean> msbSubscribertype;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getSubtype() {
    	return this.subtype;
	}
  
	public void setSubtype(String subtype) {
    	this.subtype = subtype;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public java.util.List<MsbSubscribertypeBean> getMsbSubscribertype() {
    	return this.msbSubscribertype;
	}
  
	public void setMsbSubscribertype(java.util.List<MsbSubscribertypeBean> msbSubscribertype) {
    	this.msbSubscribertype = msbSubscribertype;
	}

}
