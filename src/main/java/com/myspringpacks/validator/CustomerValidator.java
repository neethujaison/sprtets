package com.myspringpacks.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.myspringpacks.entity.CustomerForm;
import com.myspringpacks.entity.UserForm;

public class CustomerValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return CustomerForm.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		CustomerForm customer = (CustomerForm) target;
		ValidationUtils.rejectIfEmpty(errors, "customer_name", "customer_name.required","No customer_name provided");
		
		
		
		
	}

}
