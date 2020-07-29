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

public class MsbRevenueSearchBean {

    private Integer rowid;
	private String subscriber;
	private String account;
	private String from;
	private String to;
	private Double debit;
	private Double credit;
	private String description;
	private String activity;
	private java.util.Date datetime;
	private String status;
	private java.util.List<MsbRevenueBean> msbRevenue;

    public Integer getRowid(){
    	return rowid;
    }
    
    public void setRowid(Integer rowid){
    	this.rowid = rowid;
    }
    
	public String getSubscriber() {
    	return this.subscriber;
	}
  
	public void setSubscriber(String subscriber) {
    	this.subscriber = subscriber;
	}

	public String getAccount() {
    	return this.account;
	}
  
	public void setAccount(String account) {
    	this.account = account;
	}

	public String getFrom() {
    	return this.from;
	}
  
	public void setFrom(String from) {
    	this.from = from;
	}

	public String getTo() {
    	return this.to;
	}
  
	public void setTo(String to) {
    	this.to = to;
	}

	public Double getDebit() {
    	return this.debit;
	}
  
	public void setDebit(Double debit) {
    	this.debit = debit;
	}

	public Double getCredit() {
    	return this.credit;
	}
  
	public void setCredit(Double credit) {
    	this.credit = credit;
	}

	public String getDescription() {
    	return this.description;
	}
  
	public void setDescription(String description) {
    	this.description = description;
	}

	public String getActivity() {
    	return this.activity;
	}
  
	public void setActivity(String activity) {
    	this.activity = activity;
	}

	public java.util.Date getDatetime() {
    	return this.datetime;
	}
  
	public void setDatetime(java.util.Date datetime) {
    	this.datetime = datetime;
	}

	public String getStatus() {
    	return this.status;
	}
  
	public void setStatus(String status) {
    	this.status = status;
	}

	public java.util.List<MsbRevenueBean> getMsbRevenue() {
    	return this.msbRevenue;
	}
  
	public void setMsbRevenue(java.util.List<MsbRevenueBean> msbRevenue) {
    	this.msbRevenue = msbRevenue;
	}

}
