package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TCellGroup;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ai.portalhome.vo.CellGroupList;
import com.github.pagehelper.PageInfo;


public interface ITCellGroupSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TCellGroup> getList(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 获取展示列表
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public CellGroupList getShowList(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 新增
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellGroup add(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TCellGroup get(Integer id) throws Exception;
	
	/**
	 * 编辑
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellGroup edit(CellGroupInfo cellGroupInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellGroup udpateStatus(CellGroupInfo cellGroupInfo) throws Exception;
	
	
}
