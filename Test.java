package com.myspringpacks.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.myspringpacks.entity.HawbForm;
import com.myspringpacks.model.Hawbs;

public class Test {

	
	
	public static <T> boolean IsNullOrEmpty(Collection<T> list) {
	    return list == null || list.isEmpty();
	}
	public static void populateHawbListInfo(){
		List<String> hawbList = new ArrayList<String>();
		hawbList.add("mjgjgk");
		 System.out.println("Size is "+hawbList.size());
		if ((null == hawbList) || !(hawbList.size()>0)){
		 System.out.println("List is empty");
		}else{
			System.out.println("List is not empty");
		}
		List<HawbForm> test = new ArrayList<HawbForm>();
		HawbForm h= new HawbForm();
		//test.add(h);
		if (IsNullOrEmpty(test)) {
			System.out.println("test List is empty");
		}else{
			System.out.println("test List is not empty");
		}
		/*for(String hawbDTOTemp:hawbList){
			if( hawbDTOTemp.gethawbErrorList != null && hawbDTOTemp.gethawbErrorList.isEmpty()){
				Double weightinKgs;
				if(hawbDTOTemp.getWeightUnit().equals(Pound)){
					weightinKgs=hawbDTOTemp.getWeight* 0.4753;
				}else{
					weightinKgs=hawbDTOTemp.getWeight();
				}
				hawbDTOTemp.setWeight(weightinKgs);
				Double totalweight = totalweight+weightinKgs;
			}
		}*/
	}
	
	public static void main(String args[]){

		populateHawbListInfo();
		//double l = 100.5555549;
        
        //similar like RegEx but don't have much options
        //DecimalFormat df = new DecimalFormat("#.#####");
       // System.out.println(df.format(l));
		/*Map<String,String> myMap = new HashMap<String,String>();
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
		List<String> mawbNoList= new ArrayList<String>();
		for(int i=1;i<=9;i++){
			mawbNoList.add("MAWB"+i);
		}
		
		for(String mawbNo:mawbNoList){
			System.out.println("\n"+mawbNo);
		}*/
	/*	public  boolean hasDuplicates(List<String> mawbNoList) {
		    final List<String> usedNames = new ArrayList<String>();
		    for (String mawbno : mawbNoList) {
		        if (usedNames.contains(mawbno)) {
		            return true;
		        }

		        usedNames.add(mawbno);
		    }

		    return false;
		}*/
		
	}
}
