package com.ai.portalhome.dao.model;

import java.util.Date;

public class TArticleInfo {
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
        this.artName = artName == null ? null : artName.trim();
    }

    public String getArtDesc() {
        return artDesc;
    }

    public void setArtDesc(String artDesc) {
        this.artDesc = artDesc == null ? null : artDesc.trim();
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl == null ? null : artUrl.trim();
    }

    public String getArtClass() {
        return artClass;
    }

    public void setArtClass(String artClass) {
        this.artClass = artClass == null ? null : artClass.trim();
    }

    public String getArtSource() {
        return artSource;
    }

    public void setArtSource(String artSource) {
        this.artSource = artSource == null ? null : artSource.trim();
    }

    public String getArtLabel() {
        return artLabel;
    }

    public void setArtLabel(String artLabel) {
        this.artLabel = artLabel == null ? null : artLabel.trim();
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