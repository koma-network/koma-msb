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

public class MsbVersionSearchBean {

    private Integer rowid;
	private String name;
	private Integer version;
	private java.util.List<MsbVersionBean> msbVersion;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getName() {
    	return this.name;
	}
  
	public void setName(String name) {
    	this.name = name;
	}

	public Integer getVersion() {
    	return this.version;
	}
  
	public void setVersion(Integer version) {
    	this.version = version;
	}

	public java.util.List<MsbVersionBean> getMsbVersion() {
    	return this.msbVersion;
	}
  
	public void setMsbVersion(java.util.List<MsbVersionBean> msbVersion) {
    	this.msbVersion = msbVersion;
	}

}
