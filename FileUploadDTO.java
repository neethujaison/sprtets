package com.myspringpacks.entity;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadDTO {

	private String fileFormat;
	private String configFileFormat=".txt";
	private Long fileSize;
	private Long configFileSize=20L;
	private String fileName;
	private List<String> errorList;
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
	public Long getFileSize() {
		return fileSize;
	}
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}
	public Long getConfigFileSize() {
		return configFileSize;
	}
	public void setConfigFileSize(Long configFileSize) {
		this.configFileSize = configFileSize;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
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
}
