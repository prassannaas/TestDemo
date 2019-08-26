package com.megacrm.beans;

import java.util.HashMap;

public class ContactBean {

	private int contactid;
	private String firstname;
	private String lastname;
	private String designation;
	private String email;
	private String city;
	private String company;
	private int phoneno;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	public int getContactid() {
		return contactid;
	}
	public void setContactid(int contactid) {
		this.contactid = contactid;
	}
	public int getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}
	
	public HashMap<String,String> toHashMap() {
		HashMap<String,String> hmContact = new HashMap<String,String>();
		
		hmContact.put("contactid", contactid+"");
		hmContact.put("firstname", firstname);
		hmContact.put("lastname", lastname);
		hmContact.put("designation", designation);
		hmContact.put("email", email);
		hmContact.put("city", city);
		hmContact.put("company", company);
		hmContact.put("phoneno", phoneno+"");
		
		return hmContact;
	}
}
