package com.megacrm.beans;

import java.sql.Date;
import java.sql.Timestamp;

public class Convo {

	private int contactid;
	private String firstname;
	private Timestamp datetime;
	private String convo;
	private String details;
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
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
}
