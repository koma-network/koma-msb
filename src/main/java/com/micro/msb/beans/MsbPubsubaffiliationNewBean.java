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

public class MsbPubsubaffiliationNewBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private String jid;
	private Long affiliation;

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

}
