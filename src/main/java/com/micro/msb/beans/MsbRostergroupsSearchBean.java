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

public class MsbRostergroupsSearchBean {

    private Integer rowid;
	private Long rosterid;
	private Integer rank;
	private String groupname;
	private java.util.List<MsbRostergroupsBean> msbRostergroups;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public Long getRosterid() {
    	return this.rosterid;
	}
  
	public void setRosterid(Long rosterid) {
    	this.rosterid = rosterid;
	}

	public Integer getRank() {
    	return this.rank;
	}
  
	public void setRank(Integer rank) {
    	this.rank = rank;
	}

	public String getGroupname() {
    	return this.groupname;
	}
  
	public void setGroupname(String groupname) {
    	this.groupname = groupname;
	}

	public java.util.List<MsbRostergroupsBean> getMsbRostergroups() {
    	return this.msbRostergroups;
	}
  
	public void setMsbRostergroups(java.util.List<MsbRostergroupsBean> msbRostergroups) {
    	this.msbRostergroups = msbRostergroups;
	}

}
