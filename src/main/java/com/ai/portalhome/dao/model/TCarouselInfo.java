package com.ai.portalhome.dao.model;

import java.util.Date;

public class TCarouselInfo {
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
        this.carName = carName == null ? null : carName.trim();
    }

    public String getCarDesc() {
        return carDesc;
    }

    public void setCarDesc(String carDesc) {
        this.carDesc = carDesc == null ? null : carDesc.trim();
    }

    public String getCarWidth() {
        return carWidth;
    }

    public void setCarWidth(String carWidth) {
        this.carWidth = carWidth == null ? null : carWidth.trim();
    }

    public String getCarHight() {
        return carHight;
    }

    public void setCarHight(String carHight) {
        this.carHight = carHight == null ? null : carHight.trim();
    }

    public String getIfEdit() {
        return ifEdit;
    }

    public void setIfEdit(String ifEdit) {
        this.ifEdit = ifEdit == null ? null : ifEdit.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
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
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}