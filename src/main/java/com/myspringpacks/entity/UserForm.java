package com.myspringpacks.entity;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class UserForm {
	private int userid;
	//@NotEmpty(message = "Please enter your name.")
	private String name;
	private String contactno;
	
	@NotEmpty(message = "Please enter your username.")
	private String username;
	
	@NotEmpty(message = "Please enter your password.")
	private String password;
	private String status;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
