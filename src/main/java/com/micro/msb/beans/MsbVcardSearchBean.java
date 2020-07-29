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

public class MsbVcardSearchBean {

    private Integer rowid;
	private String subscriber;
	private String vcard;
	private java.util.List<MsbVcardBean> msbVcard;

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

	public String getVcard() {
    	return this.vcard;
	}
  
	public void setVcard(String vcard) {
    	this.vcard = vcard;
	}

	public java.util.List<MsbVcardBean> getMsbVcard() {
    	return this.msbVcard;
	}
  
	public void setMsbVcard(java.util.List<MsbVcardBean> msbVcard) {
    	this.msbVcard = msbVcard;
	}

}
