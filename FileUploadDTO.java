package com.myspringpacks.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDTO {

	private String fileFormat;
	private String configFileFormat="text/plain";
	
	private Double fileSize;
	private Double configFileSize=3.0;//maximum file size of each file
	
	private Double totalFileSize;//sum of all files size
	private Double configTotalSize =10.0;//sum of all files size of all files per upload
	
	
	private int totalNoOfFilesPerUpload;//total no of files per upload 
	private int configTotalNoOfFilesPerUpload = 5;//50;
	
	private String fileName;
	private String errorList;
	private MultipartFile file;
	private int fileId;
	
	public String getFileFormat() {
		return fileFormat;
	}
	public void setFileFormat(String fileFormat) {
		this.fileFormat = fileFormat;
	}
	public String getConfigFileFormat() {
		return configFileFormat;
	}
	public void setConfigFileFormat(String configFileFormat) {
		this.configFileFormat = configFileFormat;
	}
	public Double getFileSize() {
		return fileSize;
	}
	public void setFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}
	public Double getConfigFileSize() {
		return configFileSize;
	}
	public void setConfigFileSize(Double configFileSize) {
		this.configFileSize = configFileSize;
	}
	public Double getTotalFileSize() {
		return totalFileSize;
	}
	public void setTotalFileSize(Double totalFileSize) {
		this.totalFileSize = totalFileSize;
	}
	public Double getConfigTotalSize() {
		return configTotalSize;
	}
	public void setConfigTotalSize(Double configTotalSize) {
		this.configTotalSize = configTotalSize;
	}
	public int getTotalNoOfFilesPerUpload() {
		return totalNoOfFilesPerUpload;
	}
	public void setTotalNoOfFilesPerUpload(int totalNoOfFilesPerUpload) {
		this.totalNoOfFilesPerUpload = totalNoOfFilesPerUpload;
	}
	public int getConfigTotalNoOfFilesPerUpload() {
		return configTotalNoOfFilesPerUpload;
	}
	public void setConfigTotalNoOfFilesPerUpload(int configTotalNoOfFilesPerUpload) {
		this.configTotalNoOfFilesPerUpload = configTotalNoOfFilesPerUpload;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public String getErrorList() {
		return errorList;
	}
	public void setErrorList(String errorList) {
		this.errorList = errorList;
	}
	
	
	
}
