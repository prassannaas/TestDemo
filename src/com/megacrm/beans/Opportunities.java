package com.megacrm.beans;

public class Opportunities {

	private int opportunityid;
	private String subject;
	private String account;
	private String type;
	private String status;
	private int probability;
	private String notes;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getOpportunityid() {
		return opportunityid;
	}
	public void setOpportunityid(int opportunityid) {
		this.opportunityid = opportunityid;
	}
	
	
}
