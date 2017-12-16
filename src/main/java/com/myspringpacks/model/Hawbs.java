package com.myspringpacks.model;

import java.io.Serializable;

public class Hawbs implements Serializable{
    private static final long serialVersionUID = 1L;
    private int cra_hawb_detail_stg_id;
    private int cra_ahm_detail_stg_id;
    private int cra_fhl_upload_detail_id;
    private String mawb_number;
    private String hawb_number;
    public String getHawb_number() {
		return hawb_number;
	}
	public void setHawb_number(String hawb_number) {
		this.hawb_number = hawb_number;
	}
	private int hawb_noofpieces;
    private int hawb_weight;
    private boolean is_active;
    private int version;
    private String goods_description;
    private boolean isFile;
    private String docStatus;
	public int getCra_hawb_detail_stg_id() {
		return cra_hawb_detail_stg_id;
	}
	public void setCra_hawb_detail_stg_id(int cra_hawb_detail_stg_id) {
		this.cra_hawb_detail_stg_id = cra_hawb_detail_stg_id;
	}
	public int getCra_ahm_detail_stg_id() {
		return cra_ahm_detail_stg_id;
	}
	public void setCra_ahm_detail_stg_id(int cra_ahm_detail_stg_id) {
		this.cra_ahm_detail_stg_id = cra_ahm_detail_stg_id;
	}
	public int getCra_fhl_upload_detail_id() {
		return cra_fhl_upload_detail_id;
	}
	public void setCra_fhl_upload_detail_id(int cra_fhl_upload_detail_id) {
		this.cra_fhl_upload_detail_id = cra_fhl_upload_detail_id;
	}
	public String getMawb_number() {
		return mawb_number;
	}
	public void setMawb_number(String mawb_number) {
		this.mawb_number = mawb_number;
	}
	public int getHawb_noofpieces() {
		return hawb_noofpieces;
	}
	public void setHawb_noofpieces(int hawb_noofpieces) {
		this.hawb_noofpieces = hawb_noofpieces;
	}
	public int getHawb_weight() {
		return hawb_weight;
	}
	public void setHawb_weight(int hawb_weight) {
		this.hawb_weight = hawb_weight;
	}
	public boolean isIs_active() {
		return is_active;
	}
	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getGoods_description() {
		return goods_description;
	}
	public void setGoods_description(String goods_description) {
		this.goods_description = goods_description;
	}
	
	public boolean getIsFile() {
		return isFile;
	}
	public void setIsFile(boolean isFile) {
		this.isFile = isFile;
	}
	public String getDocStatus() {
		return docStatus;
	}
	public void setDocStatus(String docStatus) {
		this.docStatus = docStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
