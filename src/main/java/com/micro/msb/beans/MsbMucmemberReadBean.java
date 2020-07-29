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

public class MsbMucmemberReadBean {

    private Integer rowid;
	private Long roomid;
	private String jid;
	private String subscriber;
	private String nickname;
	private String firstname;
	private String lastname;
	private String url;
	private String email;
	private String faqentry;

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

	public String getSubscriber() {
    	return this.subscriber;
	}
  
	public void setSubscriber(String subscriber) {
    	this.subscriber = subscriber;
	}

	public String getNickname() {
    	return this.nickname;
	}
  
	public void setNickname(String nickname) {
    	this.nickname = nickname;
	}

	public String getFirstname() {
    	return this.firstname;
	}
  
	public void setFirstname(String firstname) {
    	this.firstname = firstname;
	}

	public String getLastname() {
    	return this.lastname;
	}
  
	public void setLastname(String lastname) {
    	this.lastname = lastname;
	}

	public String getUrl() {
    	return this.url;
	}
  
	public void setUrl(String url) {
    	this.url = url;
	}

	public String getEmail() {
    	return this.email;
	}
  
	public void setEmail(String email) {
    	this.email = email;
	}

	public String getFaqentry() {
    	return this.faqentry;
	}
  
	public void setFaqentry(String faqentry) {
    	this.faqentry = faqentry;
	}

}
