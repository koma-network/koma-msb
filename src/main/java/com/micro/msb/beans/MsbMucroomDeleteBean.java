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

public class MsbMucroomDeleteBean {

    private Integer rowid;
	private Long roomid;
	private Long serviceid;
	private String creationdate;
	private String modificationdate;
	private String name;
	private String naturalname;
	private String description;
	private String lockeddate;
	private String emptydate;
	private Integer canchangesubject;
	private Integer maxusers;
	private Integer publicroom;
	private Integer moderated;
	private Integer membersonly;
	private Integer caninvite;
	private String roompassword;
	private Integer candiscoverjid;
	private Integer logenabled;
	private String subject;
	private Integer rolestobroadcast;
	private Integer usereservednick;
	private Integer canchangenick;
	private Integer canregister;

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

	public Long getServiceid() {
    	return this.serviceid;
	}
  
	public void setServiceid(Long serviceid) {
    	this.serviceid = serviceid;
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

	public String getName() {
    	return this.name;
	}
  
	public void setName(String name) {
    	this.name = name;
	}

	public String getNaturalname() {
    	return this.naturalname;
	}
  
	public void setNaturalname(String naturalname) {
    	this.naturalname = naturalname;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public String getLockeddate() {
    	return this.lockeddate;
	}
  
	public void setLockeddate(String lockeddate) {
    	this.lockeddate = lockeddate;
	}

	public String getEmptydate() {
    	return this.emptydate;
	}
  
	public void setEmptydate(String emptydate) {
    	this.emptydate = emptydate;
	}

	public Integer getCanchangesubject() {
    	return this.canchangesubject;
	}
  
	public void setCanchangesubject(Integer canchangesubject) {
    	this.canchangesubject = canchangesubject;
	}

	public Integer getMaxusers() {
    	return this.maxusers;
	}
  
	public void setMaxusers(Integer maxusers) {
    	this.maxusers = maxusers;
	}

	public Integer getPublicroom() {
    	return this.publicroom;
	}
  
	public void setPublicroom(Integer publicroom) {
    	this.publicroom = publicroom;
	}

	public Integer getModerated() {
    	return this.moderated;
	}
  
	public void setModerated(Integer moderated) {
    	this.moderated = moderated;
	}

	public Integer getMembersonly() {
    	return this.membersonly;
	}
  
	public void setMembersonly(Integer membersonly) {
    	this.membersonly = membersonly;
	}

	public Integer getCaninvite() {
    	return this.caninvite;
	}
  
	public void setCaninvite(Integer caninvite) {
    	this.caninvite = caninvite;
	}

	public String getRoompassword() {
    	return this.roompassword;
	}
  
	public void setRoompassword(String roompassword) {
    	this.roompassword = roompassword;
	}

	public Integer getCandiscoverjid() {
    	return this.candiscoverjid;
	}
  
	public void setCandiscoverjid(Integer candiscoverjid) {
    	this.candiscoverjid = candiscoverjid;
	}

	public Integer getLogenabled() {
    	return this.logenabled;
	}
  
	public void setLogenabled(Integer logenabled) {
    	this.logenabled = logenabled;
	}

	public String getSubject() {
    	return this.subject;
	}
  
	public void setSubject(String subject) {
    	this.subject = subject;
	}

	public Integer getRolestobroadcast() {
    	return this.rolestobroadcast;
	}
  
	public void setRolestobroadcast(Integer rolestobroadcast) {
    	this.rolestobroadcast = rolestobroadcast;
	}

	public Integer getUsereservednick() {
    	return this.usereservednick;
	}
  
	public void setUsereservednick(Integer usereservednick) {
    	this.usereservednick = usereservednick;
	}

	public Integer getCanchangenick() {
    	return this.canchangenick;
	}
  
	public void setCanchangenick(Integer canchangenick) {
    	this.canchangenick = canchangenick;
	}

	public Integer getCanregister() {
    	return this.canregister;
	}
  
	public void setCanregister(Integer canregister) {
    	this.canregister = canregister;
	}

}
