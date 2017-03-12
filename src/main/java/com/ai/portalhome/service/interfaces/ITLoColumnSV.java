package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.vo.LoMainInfo;
import com.github.pagehelper.PageInfo;


public interface ITLoColumnSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TLoColumn> getList(LoMainInfo loMainInfo) throws Exception;
	
	/**
	 * 新增
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public TLoColumn add(LoMainInfo loMainInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TLoColumn get(Integer colId) throws Exception;
	
	/**
	 * 编辑
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public TLoColumn edit(LoMainInfo loMainInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public TLoColumn udpateStatus(LoMainInfo loMainInfo) throws Exception;
	
	
}
