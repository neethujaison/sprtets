package com.myspringpacks.model;

public class Customer {
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public int getDoctype_id() {
		return doctype_id;
	}
	public void setDoctype_id(int doctype_id) {
		this.doctype_id = doctype_id;
	}
	public int getDocument_country_id() {
		return document_country_id;
	}
	public void setDocument_country_id(int document_country_id) {
		this.document_country_id = document_country_id;
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
	public String getDocument_no() {
		return document_no;
	}
	public void setDocument_no(String document_no) {
		this.document_no = document_no;
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
	private int customer_id,country_id,city_id,doctype_id,document_country_id;

	private String customer_name;
	private String customer_address;

	private String customer_phoneno;
	private String customer_email;
	private String customer_dob,document_no,national_id,customer_status;
}
