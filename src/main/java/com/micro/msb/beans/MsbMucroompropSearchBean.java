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

public class MsbMucroompropSearchBean {

    private Integer rowid;
	private Long roomid;
	private String name;
	private String propvalue;
	private java.util.List<MsbMucroompropBean> msbMucroomprop;

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

	public java.util.List<MsbMucroompropBean> getMsbMucroomprop() {
    	return this.msbMucroomprop;
	}
  
	public void setMsbMucroomprop(java.util.List<MsbMucroompropBean> msbMucroomprop) {
    	this.msbMucroomprop = msbMucroomprop;
	}

}
