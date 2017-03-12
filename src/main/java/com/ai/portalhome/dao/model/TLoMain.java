package com.ai.portalhome.dao.model;

import java.util.Date;

public class TLoMain {
    private Integer olId;

    private Integer modelId;

    private String olName;

    private String olDesc;

    private String olType;

    private String ifEdit;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;

    public Integer getOlId() {
        return olId;
    }

    public void setOlId(Integer olId) {
        this.olId = olId;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getOlName() {
        return olName;
    }

    public void setOlName(String olName) {
        this.olName = olName == null ? null : olName.trim();
    }

    public String getOlDesc() {
        return olDesc;
    }

    public void setOlDesc(String olDesc) {
        this.olDesc = olDesc == null ? null : olDesc.trim();
    }

    public String getOlType() {
        return olType;
    }

    public void setOlType(String olType) {
        this.olType = olType == null ? null : olType.trim();
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