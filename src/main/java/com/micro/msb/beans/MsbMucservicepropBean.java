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
public class MsbMucservicepropBean {

    private Integer rowid;
	private Long serviceid;
	private String name;
	private String propvalue;

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

	public String getName() {
    	return this.name;
	}
  
	public void setName(String name) {
    	this.name = name;
	}

	public String getPropvalue() {
    	return this.propvalue;
	}
  
	public void setPropvalue(String propvalue) {
    	this.propvalue = propvalue;
	}

}
