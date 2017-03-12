package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

import com.ai.portalhome.dao.model.TSysRole;

public class ArticleInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer groupId;
	
	private Integer artId;

    private String artName;

    private String artDesc;

    private String artUrl;

    private String artClass;

    private String artSource;

    private String artLabel;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    private Integer fileId;


    private String fileName;

    private String fileDesc;

    private String filePath;

    private String fileType;

    private String fileSize;

    private Integer fileOrder;
    
    private List<Integer> ids;

	public Integer getArtId() {
		return artId;
	}

	public void setArtId(Integer artId) {
		this.artId = artId;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getArtDesc() {
		return artDesc;
	}

	public void setArtDesc(String artDesc) {
		this.artDesc = artDesc;
	}

	public String getArtUrl() {
		return artUrl;
	}

	public void setArtUrl(String artUrl) {
		this.artUrl = artUrl;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDesc() {
		return fileDesc;
	}

	public void setFileDesc(String fileDesc) {
		this.fileDesc = fileDesc;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public Integer getFileOrder() {
		return fileOrder;
	}

	public void setFileOrder(Integer fileOrder) {
		this.fileOrder = fileOrder;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getArtClass() {
		return artClass;
	}

	public void setArtClass(String artClass) {
		this.artClass = artClass;
	}

	public String getArtSource() {
		return artSource;
	}

	public void setArtSource(String artSource) {
		this.artSource = artSource;
	}

	public String getArtLabel() {
		return artLabel;
	}

	public void setArtLabel(String artLabel) {
		this.artLabel = artLabel;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}


    
    

}
