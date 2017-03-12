package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TSysRole;

public class ArticleGroupInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer groupId;

    private String groupName;

    private String groupDesc;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    private Integer gcId;

    private Integer artId;

    private Integer gcOrder;
    
    private TArticleInfo articleInfo;
    
    private List<Integer> ids;

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
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

	public Integer getGcId() {
		return gcId;
	}

	public void setGcId(Integer gcId) {
		this.gcId = gcId;
	}

	public Integer getArtId() {
		return artId;
	}

	public void setArtId(Integer artId) {
		this.artId = artId;
	}

	public Integer getGcOrder() {
		return gcOrder;
	}

	public void setGcOrder(Integer gcOrder) {
		this.gcOrder = gcOrder;
	}

	public TArticleInfo getArticleInfo() {
		return articleInfo;
	}

	public void setArticleInfo(TArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}

    
    
    

}
