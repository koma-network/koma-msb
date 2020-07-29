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

public class MsbPubsubnodeWriteBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private Integer leaf;
	private String creationdate;
	private String modificationdate;
	private String parent;
	private Integer deliverpayloads;
	private Integer maxpayloadsize;
	private Integer persistitems;
	private Integer maxitems;
	private Integer notifyconfigchanges;
	private Integer notifydelete;
	private Integer notifyretract;
	private Integer presencebased;
	private Integer senditemsubscribe;
	private String publishermodel;
	private Integer subscriptionenabled;
	private Integer configsubscription;
	private String accessmodel;
	private String payloadtype;
	private String bodyxslt;
	private String dataformxslt;
	private String creator;
	private String description;
	private String language;
	private String name;
	private String replypolicy;
	private String associationpolicy;
	private Integer maxleafnodes;

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

	public Integer getLeaf() {
    	return this.leaf;
	}
  
	public void setLeaf(Integer leaf) {
    	this.leaf = leaf;
	}

	public String getCreationdate() {
    	return this.creationdate;
	}
  
	public void setCreationdate(String creationdate) {
    	this.creationdate = creationdate;
	}

	public String getModificationdate() {
    	return this.modificationdate;
	}
  
	public void setModificationdate(String modificationdate) {
    	this.modificationdate = modificationdate;
	}

	public String getParent() {
    	return this.parent;
	}
  
	public void setParent(String parent) {
    	this.parent = parent;
	}

	public Integer getDeliverpayloads() {
    	return this.deliverpayloads;
	}
  
	public void setDeliverpayloads(Integer deliverpayloads) {
    	this.deliverpayloads = deliverpayloads;
	}

	public Integer getMaxpayloadsize() {
    	return this.maxpayloadsize;
	}
  
	public void setMaxpayloadsize(Integer maxpayloadsize) {
    	this.maxpayloadsize = maxpayloadsize;
	}

	public Integer getPersistitems() {
    	return this.persistitems;
	}
  
	public void setPersistitems(Integer persistitems) {
    	this.persistitems = persistitems;
	}

	public Integer getMaxitems() {
    	return this.maxitems;
	}
  
	public void setMaxitems(Integer maxitems) {
    	this.maxitems = maxitems;
	}

	public Integer getNotifyconfigchanges() {
    	return this.notifyconfigchanges;
	}
  
	public void setNotifyconfigchanges(Integer notifyconfigchanges) {
    	this.notifyconfigchanges = notifyconfigchanges;
	}

	public Integer getNotifydelete() {
    	return this.notifydelete;
	}
  
	public void setNotifydelete(Integer notifydelete) {
    	this.notifydelete = notifydelete;
	}

	public Integer getNotifyretract() {
    	return this.notifyretract;
	}
  
	public void setNotifyretract(Integer notifyretract) {
    	this.notifyretract = notifyretract;
	}

	public Integer getPresencebased() {
    	return this.presencebased;
	}
  
	public void setPresencebased(Integer presencebased) {
    	this.presencebased = presencebased;
	}

	public Integer getSenditemsubscribe() {
    	return this.senditemsubscribe;
	}
  
	public void setSenditemsubscribe(Integer senditemsubscribe) {
    	this.senditemsubscribe = senditemsubscribe;
	}

	public String getPublishermodel() {
    	return this.publishermodel;
	}
  
	public void setPublishermodel(String publishermodel) {
    	this.publishermodel = publishermodel;
	}

	public Integer getSubscriptionenabled() {
    	return this.subscriptionenabled;
	}
  
	public void setSubscriptionenabled(Integer subscriptionenabled) {
    	this.subscriptionenabled = subscriptionenabled;
	}

	public Integer getConfigsubscription() {
    	return this.configsubscription;
	}
  
	public void setConfigsubscription(Integer configsubscription) {
    	this.configsubscription = configsubscription;
	}

	public String getAccessmodel() {
    	return this.accessmodel;
	}
  
	public void setAccessmodel(String accessmodel) {
    	this.accessmodel = accessmodel;
	}

	public String getPayloadtype() {
    	return this.payloadtype;
	}
  
	public void setPayloadtype(String payloadtype) {
    	this.payloadtype = payloadtype;
	}

	public String getBodyxslt() {
    	return this.bodyxslt;
	}
  
	public void setBodyxslt(String bodyxslt) {
    	this.bodyxslt = bodyxslt;
	}

	public String getDataformxslt() {
    	return this.dataformxslt;
	}
  
	public void setDataformxslt(String dataformxslt) {
    	this.dataformxslt = dataformxslt;
	}

	public String getCreator() {
    	return this.creator;
	}
  
	public void setCreator(String creator) {
    	this.creator = creator;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public String getLanguage() {
    	return this.language;
	}
  
	public void setLanguage(String language) {
    	this.language = language;
	}

	public String getName() {
    	return this.name;
	}
  
	public void setName(String name) {
    	this.name = name;
	}

	public String getReplypolicy() {
    	return this.replypolicy;
	}
  
	public void setReplypolicy(String replypolicy) {
    	this.replypolicy = replypolicy;
	}

	public String getAssociationpolicy() {
    	return this.associationpolicy;
	}
  
	public void setAssociationpolicy(String associationpolicy) {
    	this.associationpolicy = associationpolicy;
	}

	public Integer getMaxleafnodes() {
    	return this.maxleafnodes;
	}
  
	public void setMaxleafnodes(Integer maxleafnodes) {
    	this.maxleafnodes = maxleafnodes;
	}

}
