package com.myspringpacks.entity;


import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class AhmForm {
	private String mawbno;
	private int noofpieces;
	private int weight;
	public int getNoofpieces() {
		return noofpieces;
	}
	public int getWeight() {
		return weight;
	}
	public void setNoofpieces(int noofpieces) {
		this.noofpieces = noofpieces;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public String getMawbno() {
		return mawbno;
	}
	public void setMawbno(String mawbno) {
		this.mawbno = mawbno;
	}
	
	

}
