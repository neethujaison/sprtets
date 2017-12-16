package com.myspringpacks.entity;

public class HawbForm {

	private  String hawbno;
	private  int noofpieces;
	private int weight;
	private String goods_description;
	public String getGoods_description() {
		return goods_description;
	}
	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}
	public String getHawbno() {
		return hawbno;
	}
	public void setHawbno(String hawbno) {
		this.hawbno = hawbno;
	}
	public int getNoofpieces() {
		return noofpieces;
	}
	public void setNoofpieces(int noofpieces) {
		this.noofpieces = noofpieces;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
