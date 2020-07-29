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

public class MsbMucaffiliationSearchBean {

    private Integer rowid;
	private Long roomid;
	private String jid;
	private Long affiliation;
	private java.util.List<MsbMucaffiliationBean> msbMucaffiliation;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public Long getRoomid() {
    	return this.roomid;
	}
  
	public void setRoomid(Long roomid) {
    	this.roomid = roomid;
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

	public java.util.List<MsbMucaffiliationBean> getMsbMucaffiliation() {
    	return this.msbMucaffiliation;
	}
  
	public void setMsbMucaffiliation(java.util.List<MsbMucaffiliationBean> msbMucaffiliation) {
    	this.msbMucaffiliation = msbMucaffiliation;
	}

}
