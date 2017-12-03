package com.myspringpacks.json;

import java.util.Map;

import com.myspringpacks.entity.UserForm;

public class UserJSONResponse {
	
	private UserForm userForm;
	private boolean validated;
	private Map<String,String> errorMessages;
	
	public UserForm getUserForm() {
		return userForm;
	}
	public void setUserForm(UserForm userForm) {
		this.userForm = userForm;
	}
	public boolean isValidated() {
		return validated;
	}
	public void setValidated(boolean validated) {
		this.validated = validated;
	}
	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

}
