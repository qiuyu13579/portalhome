package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

public class HomeMenuInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8092120222509299162L;
	

	private Integer menuId;

    private Integer modelId;

    private Integer menuSup;

    private String menuName;

    private String menuDesc;

    private String menuUrl;

    private Integer menuOrder;

    private String menuType;

    private String ifEdit;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    
    private List<Integer> menulist;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public Integer getMenuSup() {
		return menuSup;
	}

	public void setMenuSup(Integer menuSup) {
		this.menuSup = menuSup;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getIfEdit() {
		return ifEdit;
	}

	public void setIfEdit(String ifEdit) {
		this.ifEdit = ifEdit;
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

	public List<Integer> getMenulist() {
		return menulist;
	}

	public void setMenulist(List<Integer> menulist) {
		this.menulist = menulist;
	}
    
    
    
    
    
    

}
