package com.ai.portalhome.vo;

import java.util.Date;
import java.util.List;

import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.dao.model.TLoColumnData;

public class CustomInfo extends BaseVO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
private Integer modelId;
	
	private Integer olId;

    private String olName;

    private String olDesc;

    private String olType;

    private Integer colId;

    private String colTitle;

    private String colDesc;

    private String colType;

    private Integer colX;

    private Integer colY;

    private Integer colWidth;

    private Integer colHeigh;

    private Integer colOrder;

    private Integer dataId;

    private String dataUrl;

    private Integer carId;

    private String imageUrl;

    private Integer artId;

    private Integer agId;

    private Integer unId;

    private Integer tgId;

    private String urlAdress;

    private String ifEdit;

    private String status;

    private String createUser;

    private Date createTime;

    private String updateUser;

    private Date updateTime;
	

//	private LoMainInfo loMainInfo;
	
	private List<TLoColumnData> listData;
	
	private TLoColumn column;
	
	private TLoColumnData columnData;


	public Integer getModelId() {
		return modelId;
	}


	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}


	public Integer getOlId() {
		return olId;
	}


	public void setOlId(Integer olId) {
		this.olId = olId;
	}


	public String getOlName() {
		return olName;
	}


	public void setOlName(String olName) {
		this.olName = olName;
	}


	public String getOlDesc() {
		return olDesc;
	}


	public void setOlDesc(String olDesc) {
		this.olDesc = olDesc;
	}


	public String getOlType() {
		return olType;
	}


	public void setOlType(String olType) {
		this.olType = olType;
	}


	public Integer getColId() {
		return colId;
	}


	public void setColId(Integer colId) {
		this.colId = colId;
	}


	public String getColTitle() {
		return colTitle;
	}


	public void setColTitle(String colTitle) {
		this.colTitle = colTitle;
	}


	public String getColDesc() {
		return colDesc;
	}


	public void setColDesc(String colDesc) {
		this.colDesc = colDesc;
	}


	public String getColType() {
		return colType;
	}


	public void setColType(String colType) {
		this.colType = colType;
	}


	public Integer getColX() {
		return colX;
	}


	public void setColX(Integer colX) {
		this.colX = colX;
	}


	public Integer getColY() {
		return colY;
	}


	public void setColY(Integer colY) {
		this.colY = colY;
	}


	public Integer getColWidth() {
		return colWidth;
	}


	public void setColWidth(Integer colWidth) {
		this.colWidth = colWidth;
	}


	public Integer getColHeigh() {
		return colHeigh;
	}


	public void setColHeigh(Integer colHeigh) {
		this.colHeigh = colHeigh;
	}


	public Integer getColOrder() {
		return colOrder;
	}


	public void setColOrder(Integer colOrder) {
		this.colOrder = colOrder;
	}


	public Integer getDataId() {
		return dataId;
	}


	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}


	public String getDataUrl() {
		return dataUrl;
	}


	public void setDataUrl(String dataUrl) {
		this.dataUrl = dataUrl;
	}


	public Integer getCarId() {
		return carId;
	}


	public void setCarId(Integer carId) {
		this.carId = carId;
	}


	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Integer getArtId() {
		return artId;
	}


	public void setArtId(Integer artId) {
		this.artId = artId;
	}


	public Integer getAgId() {
		return agId;
	}


	public void setAgId(Integer agId) {
		this.agId = agId;
	}


	public Integer getUnId() {
		return unId;
	}


	public void setUnId(Integer unId) {
		this.unId = unId;
	}


	public Integer getTgId() {
		return tgId;
	}


	public void setTgId(Integer tgId) {
		this.tgId = tgId;
	}


	public String getUrlAdress() {
		return urlAdress;
	}


	public void setUrlAdress(String urlAdress) {
		this.urlAdress = urlAdress;
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


	public List<TLoColumnData> getListData() {
		return listData;
	}


	public void setListData(List<TLoColumnData> listData) {
		this.listData = listData;
	}


	public TLoColumn getColumn() {
		return column;
	}


	public void setColumn(TLoColumn column) {
		this.column = column;
	}


	public TLoColumnData getColumnData() {
		return columnData;
	}


	public void setColumnData(TLoColumnData columnData) {
		this.columnData = columnData;
	}
    
    
    

}
