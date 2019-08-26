package com.megacrm.beans;

import java.sql.Timestamp;

public class OConvo {
	
	private int opportunityid;
	private String subject;
	private Timestamp datetime;
	private String convo;
	private String details;
	public int getOpportunityid() {
		return opportunityid;
	}
	public void setOpportunityid(int opportunityid) {
		this.opportunityid = opportunityid;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public String getConvo() {
		return convo;
	}
	public void setConvo(String convo) {
		this.convo = convo;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
