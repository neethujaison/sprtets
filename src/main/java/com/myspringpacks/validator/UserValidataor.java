package com.myspringpacks.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myspringpacks.entity.UserForm;

public class UserValidataor implements Validator{

	public boolean supports(Class<?> clazz) {
		
		return UserForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserForm user=(UserForm)target;
		ValidationUtils.rejectIfEmpty(errors, "name", "name.required","No name provided");
		
	}

}
