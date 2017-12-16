package com.myspringpacks.model;

public class Ahm {
	private int cra_ahm_detail_stg_id;
	private int cmn_ref_transaction_type_id;

	private String mawb_number;
	private int noofpieces;

	private int totalnoofhawbs;
	private int totalhawbsweight;

	private int weight;
	private int version;
	private boolean is_active;
	public int getCra_ahm_detail_stg_id() {
		return cra_ahm_detail_stg_id;
	}
	public void setCra_ahm_detail_stg_id(int cra_ahm_detail_stg_id) {
		this.cra_ahm_detail_stg_id = cra_ahm_detail_stg_id;
	}
	public int getCmn_ref_transaction_type_id() {
		return cmn_ref_transaction_type_id;
	}
	public void setCmn_ref_transaction_type_id(int cmn_ref_transaction_type_id) {
		this.cmn_ref_transaction_type_id = cmn_ref_transaction_type_id;
	}
	public String getMawb_number() {
		return mawb_number;
	}
	public void setMawb_number(String mawb_number) {
		this.mawb_number = mawb_number;
	}
	public int getNoofpieces() {
		return noofpieces;
	}
	public void setNoofpieces(int noofpieces) {
		this.noofpieces = noofpieces;
	}
	public int getTotalnoofhawbs() {
		return totalnoofhawbs;
	}
	public void setTotalnoofhawbs(int totalnoofhawbs) {
		this.totalnoofhawbs = totalnoofhawbs;
	}
	public int getTotalhawbsweight() {
		return totalhawbsweight;
	}
	public void setTotalhawbsweight(int totalhawbsweight) {
		this.totalhawbsweight = totalhawbsweight;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
}
