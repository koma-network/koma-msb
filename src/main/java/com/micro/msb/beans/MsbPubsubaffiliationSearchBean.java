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

public class MsbPubsubaffiliationSearchBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private String jid;
	private Long affiliation;
	private java.util.List<MsbPubsubaffiliationBean> msbPubsubaffiliation;

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

	public String getJid() {
    	return this.jid;
	}
  
	public void setJid(String jid) {
    	this.jid = jid;
	}

	public Long getAffiliation() {
    	return this.affiliation;
	}
  
	public void setAffiliation(Long affiliation) {
    	this.affiliation = affiliation;
	}

	public java.util.List<MsbPubsubaffiliationBean> getMsbPubsubaffiliation() {
    	return this.msbPubsubaffiliation;
	}
  
	public void setMsbPubsubaffiliation(java.util.List<MsbPubsubaffiliationBean> msbPubsubaffiliation) {
    	this.msbPubsubaffiliation = msbPubsubaffiliation;
	}

}
