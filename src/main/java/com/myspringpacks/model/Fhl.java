package com.myspringpacks.model;

public class Fhl {
	private String filename;
	private byte[] file_data;
	private int cra_fhl_upload_detail_id;
	private int cra_ahm_detail_stg_id;
	private String mawb_number;
	public String getMawb_number() {
		return mawb_number;
	}
	public void setMawb_number(String mawb_number) {
		this.mawb_number = mawb_number;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public byte[] getFile_data() {
		return file_data;
	}
	public void setFile_data(byte[] file_data) {
		this.file_data = file_data;
	}
	public int getCra_fhl_upload_detail_id() {
		return cra_fhl_upload_detail_id;
	}
	public void setCra_fhl_upload_detail_id(int cra_fhl_upload_detail_id) {
		this.cra_fhl_upload_detail_id = cra_fhl_upload_detail_id;
	}
	public int getCra_ahm_detail_stg_id() {
		return cra_ahm_detail_stg_id;
	}
	public void setCra_ahm_detail_stg_id(int cra_ahm_detail_stg_id) {
		this.cra_ahm_detail_stg_id = cra_ahm_detail_stg_id;
	}
}
