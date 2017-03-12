package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

public class UserInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userName;

    private String userAsname;

    private String userNumber;

    private String userPhone;

    private String userEmail;

    private String userAddress;

    private String lockStatus;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    private List<Integer> rolelist;
    
    

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAsname() {
		return userAsname;
	}

	public void setUserAsname(String userAsname) {
		this.userAsname = userAsname;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
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

	public List<Integer> getRolelist() {
		return rolelist;
	}

	public void setRolelist(List<Integer> rolelist) {
		this.rolelist = rolelist;
	}

    
    
    
    

}
