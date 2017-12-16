package com.myspringpacks.controller;

import java.util.HashMap;
import java.util.Map;

import com.myspringpacks.model.Hawbs;

public class Test {

	
	public static void main(String args[]){

		Map<String,String> myMap = new HashMap<String,String>();
		myMap.put("firstName", "Neethu");
		myMap.put("secondName", "Joseph");
		myMap.put("Nithin", "Joseph");
		if(myMap.containsKey("secondName")){
			System.out.println(""+myMap);
		}
		Map<String,Object> commonMap = new HashMap<String,Object>();
		Object value;
		String str= "Nitz";
		Hawbs hawb = new Hawbs();
		commonMap.put("first", hawb);
		
	}
}
