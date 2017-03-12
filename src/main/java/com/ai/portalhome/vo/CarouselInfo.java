package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.dao.model.TSysRole;

public class CarouselInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer carId;

    private String carName;

    private String carDesc;

    private String carWidth;

    private String carHight;

    private String ifEdit;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
    
    
    private Integer dataId;


    private String carImage;

    private String carTitle;

    private String carUrl;

    private Integer carOrder;

    private List<TCarouselData> dataList;
    

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarDesc() {
		return carDesc;
	}

	public void setCarDesc(String carDesc) {
		this.carDesc = carDesc;
	}

	public String getCarWidth() {
		return carWidth;
	}

	public void setCarWidth(String carWidth) {
		this.carWidth = carWidth;
	}

	public String getCarHight() {
		return carHight;
	}

	public void setCarHight(String carHight) {
		this.carHight = carHight;
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

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public String getCarImage() {
		return carImage;
	}

	public void setCarImage(String carImage) {
		this.carImage = carImage;
	}

	public String getCarTitle() {
		return carTitle;
	}

	public void setCarTitle(String carTitle) {
		this.carTitle = carTitle;
	}

	public String getCarUrl() {
		return carUrl;
	}

	public void setCarUrl(String carUrl) {
		this.carUrl = carUrl;
	}

	public Integer getCarOrder() {
		return carOrder;
	}

	public void setCarOrder(Integer carOrder) {
		this.carOrder = carOrder;
	}

	public List<TCarouselData> getDataList() {
		return dataList;
	}

	public void setDataList(List<TCarouselData> dataList) {
		this.dataList = dataList;
	}

    
    
    
    

}
