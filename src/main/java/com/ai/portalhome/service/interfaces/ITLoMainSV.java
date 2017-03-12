package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TLoMain;
import com.ai.portalhome.vo.CustomInfo;
import com.ai.portalhome.vo.LoMainInfo;
import com.github.pagehelper.PageInfo;


public interface ITLoMainSV {
	
	
	/**
	 * 查询单个布局信息
	 * 
	 * @param olId
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo getLo(Integer olId) throws Exception;
	
	/**
	 * 编辑布局栏目
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo editLoColumn(LoMainInfo loMainInfo) throws Exception;
	
	
	/**
	 *  获取栏目基本信息
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public CustomInfo getColumn(CustomInfo customInfo) throws Exception;
	
	
	
	
	/**
	 * 获取布局列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TLoMain> getLoList(LoMainInfo loMainInfo) throws Exception;
	
	/**
	 * 新增布局
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo addLo(LoMainInfo loMainInfo) throws Exception;
	
	
	/**
	 * 查询布局列表 - 后台管理展示
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<LoMainInfo> queryLoList(LoMainInfo loMainInfo) throws Exception;
	
	/**
	 * 编辑布局
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo editLo(LoMainInfo loMainInfo) throws Exception;
	
	
	/**
	 * 更新布局状态
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo udpateStatus(LoMainInfo loMainInfo) throws Exception;
	
	
}
