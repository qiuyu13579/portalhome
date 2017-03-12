package com.ai.portalhome.dao.model;

import java.util.Date;

public class TCellInfo {
    private Integer celId;

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

    public Integer getCelId() {
        return celId;
    }

    public void setCelId(Integer celId) {
        this.celId = celId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getCelName() {
        return celName;
    }

    public void setCelName(String celName) {
        this.celName = celName == null ? null : celName.trim();
    }

    public String getCelUrl() {
        return celUrl;
    }

    public void setCelUrl(String celUrl) {
        this.celUrl = celUrl == null ? null : celUrl.trim();
    }

    public String getCelImage() {
        return celImage;
    }

    public void setCelImage(String celImage) {
        this.celImage = celImage == null ? null : celImage.trim();
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