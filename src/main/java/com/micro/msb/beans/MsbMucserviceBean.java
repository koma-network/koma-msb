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
public class MsbMucserviceBean {

    private Integer rowid;
	private Long serviceid;
	private String domain;
	private String subdomain;
	private String description;
	private Integer ishidden;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public Long getServiceid() {
    	return this.serviceid;
	}
  
	public void setServiceid(Long serviceid) {
    	this.serviceid = serviceid;
	}

	public String getDomain() {
    	return this.domain;
	}
  
	public void setDomain(String domain) {
    	this.domain = domain;
	}

	public String getSubdomain() {
    	return this.subdomain;
	}
  
	public void setSubdomain(String subdomain) {
    	this.subdomain = subdomain;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public Integer getIshidden() {
    	return this.ishidden;
	}
  
	public void setIshidden(Integer ishidden) {
    	this.ishidden = ishidden;
	}

}
