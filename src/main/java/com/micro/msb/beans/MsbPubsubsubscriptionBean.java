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
public class MsbPubsubsubscriptionBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private String id;
	private String jid;
	private String owner;
	private String state;
	private Integer deliver;
	private Integer digest;
	private Integer digestFrequency;
	private String expire;
	private Integer includebody;
	private String showvalues;
	private String subscriptiontype;
	private Integer subscriptiondepth;
	private String keyword;

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

	public String getOwner() {
    	return this.owner;
	}
  
	public void setOwner(String owner) {
    	this.owner = owner;
	}

	public String getState() {
    	return this.state;
	}
  
	public void setState(String state) {
    	this.state = state;
	}

	public Integer getDeliver() {
    	return this.deliver;
	}
  
	public void setDeliver(Integer deliver) {
    	this.deliver = deliver;
	}

	public Integer getDigest() {
    	return this.digest;
	}
  
	public void setDigest(Integer digest) {
    	this.digest = digest;
	}

	public Integer getDigestFrequency() {
    	return this.digestFrequency;
	}
  
	public void setDigestFrequency(Integer digestFrequency) {
    	this.digestFrequency = digestFrequency;
	}

	public String getExpire() {
    	return this.expire;
	}
  
	public void setExpire(String expire) {
    	this.expire = expire;
	}

	public Integer getIncludebody() {
    	return this.includebody;
	}
  
	public void setIncludebody(Integer includebody) {
    	this.includebody = includebody;
	}

	public String getShowvalues() {
    	return this.showvalues;
	}
  
	public void setShowvalues(String showvalues) {
    	this.showvalues = showvalues;
	}

	public String getSubscriptiontype() {
    	return this.subscriptiontype;
	}
  
	public void setSubscriptiontype(String subscriptiontype) {
    	this.subscriptiontype = subscriptiontype;
	}

	public Integer getSubscriptiondepth() {
    	return this.subscriptiondepth;
	}
  
	public void setSubscriptiondepth(Integer subscriptiondepth) {
    	this.subscriptiondepth = subscriptiondepth;
	}

	public String getKeyword() {
    	return this.keyword;
	}
  
	public void setKeyword(String keyword) {
    	this.keyword = keyword;
	}

}
