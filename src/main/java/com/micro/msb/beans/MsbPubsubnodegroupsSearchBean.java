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

public class MsbPubsubnodegroupsSearchBean {

    private Integer rowid;
	private String serviceid;
	private String nodeid;
	private String rostergroup;
	private java.util.List<MsbPubsubnodegroupsBean> msbPubsubnodegroups;

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

	public String getRostergroup() {
    	return this.rostergroup;
	}
  
	public void setRostergroup(String rostergroup) {
    	this.rostergroup = rostergroup;
	}

	public java.util.List<MsbPubsubnodegroupsBean> getMsbPubsubnodegroups() {
    	return this.msbPubsubnodegroups;
	}
  
	public void setMsbPubsubnodegroups(java.util.List<MsbPubsubnodegroupsBean> msbPubsubnodegroups) {
    	this.msbPubsubnodegroups = msbPubsubnodegroups;
	}

}
