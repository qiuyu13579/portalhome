package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.THomeMenu;
import com.ai.portalhome.vo.HomeMenuInfo;
import com.ai.portalhome.vo.HomeMenuList;
import com.github.pagehelper.PageInfo;


public interface ITHomeMenuSV {
	
	/**
	 * 获取菜单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<THomeMenu> getHomeMenuList(HomeMenuInfo homeMenuInfo) throws Exception;
	
	/**
	 * 新增菜单
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	public THomeMenu addHomeMenu(HomeMenuInfo homeMenuInfo) throws Exception;
	
	/**
	 * 查询单个菜单信息
	 * 
	 * @param menuId
	 * @return
	 * @throws Exception
	 */
	public THomeMenu getHomeMenu(Integer menuId) throws Exception;
	
	/**
	 * 查询菜单列表 - 后台管理展示
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<HomeMenuList> queryHomeMenuList(HomeMenuInfo homeMenuInfo) throws Exception;
//	public PageInfo<THomeMenu> queryHomeMenuList(HomeMenuInfo homeMenuInfo) throws Exception;
	
	/**
	 * 编辑菜单
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	public THomeMenu editHomeMenu(HomeMenuInfo homeMenuInfo) throws Exception;
	
	
	/**
	 * 更新菜单状态
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	public THomeMenu udpateStatus(HomeMenuInfo homeMenuInfo) throws Exception;
	
	
}
