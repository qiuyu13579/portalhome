package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TSysRole;

public class CellGroupInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 private Integer groupId;

	    private String celName;

	    private String celUrl;

	    private String celImage;

	    private Integer celOrder;

	    private String status;

	    private String createUser;

	    private Date createTime;

	    private String updateUser;

	    private Date updateTime;

	    private String groupName;

	    private String groupDesc;
	    
	    private Integer celId;


		public String getCelName() {
			return celName;
		}

		public void setCelName(String celName) {
			this.celName = celName;
		}

		public String getCelUrl() {
			return celUrl;
		}

		public void setCelUrl(String celUrl) {
			this.celUrl = celUrl;
		}

		public String getCelImage() {
			return celImage;
		}

		public void setCelImage(String celImage) {
			this.celImage = celImage;
		}

		public Integer getCelOrder() {
			return celOrder;
		}

		public void setCelOrder(Integer celOrder) {
			this.celOrder = celOrder;
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

		public Integer getCelId() {
			return celId;
		}

		public void setCelId(Integer celId) {
			this.celId = celId;
		}
    
    

}
