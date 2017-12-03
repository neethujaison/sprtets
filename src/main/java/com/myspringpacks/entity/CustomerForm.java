package com.myspringpacks.entity;

public class CustomerForm {
	private int customer_id;
	private String customer_name;
	private String customer_address;
	private String country;
	private String city;
	private String customer_phoneno;
	private String customer_email;
	private String customer_dob;
	private String doctype_name;

	
	private String document_no;

	private String document_country_name;
	private String national_id;
	private String customer_status;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_address() {
		return customer_address;
	}

	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	
	public String getCustomer_phoneno() {
		return customer_phoneno;
	}

	public void setCustomer_phoneno(String customer_phoneno) {
		this.customer_phoneno = customer_phoneno;
	}

	public String getCustomer_email() {
		return customer_email;
	}

	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	public String getCustomer_dob() {
		return customer_dob;
	}

	public void setCustomer_dob(String customer_dob) {
		this.customer_dob = customer_dob;
	}

	public String getDoctype_name() {
		return doctype_name;
	}

	public void setDoctype_id(String doctype_id) {
		this.doctype_name = doctype_name;
	}

	public String getDocument_no() {
		return document_no;
	}

	public void setDocument_no(String document_no) {
		this.document_no = document_no;
	}

	public String getDocument_country_name() {
		return document_country_name;
	}

	public void setDocument_country_name(String document_country_name) {
		this.document_country_name = document_country_name;
	}

	public String getNational_id() {
		return national_id;
	}

	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}

	public String getCustomer_status() {
		return customer_status;
	}

	public void setCustomer_status(String customer_status) {
		this.customer_status = customer_status;
	}

	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
