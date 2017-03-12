package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TCellInfo;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ai.portalhome.vo.CellGroupList;
import com.github.pagehelper.PageInfo;


public interface ITCellInfoSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TCellInfo> getList(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 获取展示列表
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public List<TCellInfo> getAllList(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 新增
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellInfo add(CellGroupInfo cellGroupInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TCellInfo get(Integer id) throws Exception;
	
	/**
	 * 编辑
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellInfo edit(CellGroupInfo cellGroupInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellInfo udpateStatus(CellGroupInfo cellGroupInfo) throws Exception;
	
	
}
