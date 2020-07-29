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

public class MsbAffiliationSearchBean {

    private Integer rowid;
	private Long affiliation;
	private String description;
	private java.util.List<MsbAffiliationBean> msbAffiliation;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public Long getAffiliation() {
    	return this.affiliation;
	}
  
	public void setAffiliation(Long affiliation) {
    	this.affiliation = affiliation;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public java.util.List<MsbAffiliationBean> getMsbAffiliation() {
    	return this.msbAffiliation;
	}
  
	public void setMsbAffiliation(java.util.List<MsbAffiliationBean> msbAffiliation) {
    	this.msbAffiliation = msbAffiliation;
	}

}
