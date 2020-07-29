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

public class MsbPubsubitemSearchBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private String id;
	private String jid;
	private String creationdate;
	private String payload;
	private java.util.List<MsbPubsubitemBean> msbPubsubitem;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getServiceid() {
    	return this.serviceid;
	}
  
	public void setServiceid(String serviceid) {
    	this.serviceid = serviceid;
	}

	public String getNodeid() {
    	return this.nodeid;
	}
  
	public void setNodeid(String nodeid) {
    	this.nodeid = nodeid;
	}

	public String getId() {
    	return this.id;
	}
  
	public void setId(String id) {
    	this.id = id;
	}

	public String getJid() {
    	return this.jid;
	}
  
	public void setJid(String jid) {
    	this.jid = jid;
	}

	public String getCreationdate() {
    	return this.creationdate;
	}
  
	public void setCreationdate(String creationdate) {
    	this.creationdate = creationdate;
	}

	public String getPayload() {
    	return this.payload;
	}
  
	public void setPayload(String payload) {
    	this.payload = payload;
	}

	public java.util.List<MsbPubsubitemBean> getMsbPubsubitem() {
    	return this.msbPubsubitem;
	}
  
	public void setMsbPubsubitem(java.util.List<MsbPubsubitemBean> msbPubsubitem) {
    	this.msbPubsubitem = msbPubsubitem;
	}

}
