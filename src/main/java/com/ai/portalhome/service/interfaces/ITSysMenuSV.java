package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.vo.MenuInfo;
import com.github.pagehelper.PageInfo;


public interface ITSysMenuSV {
	
	/**
	 * 获取菜单列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysMenu> getMenuList(MenuInfo menuInfo) throws Exception;
	
	/**
	 * 新增菜单
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysMenu addMenu(MenuInfo menuInfo) throws Exception;
	
	/**
	 * 查询单个菜单信息
	 * 
	 * @param menuId
	 * @return
	 * @throws Exception
	 */
	public TSysMenu getMenu(Integer menuId) throws Exception;
	
	/**
	 * 查询菜单列表 - 后台管理展示
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysMenu> queryMenuList(MenuInfo menuInfo) throws Exception;
	
	/**
	 * 编辑菜单
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysMenu editMenu(MenuInfo menuInfo) throws Exception;
	
	
	/**
	 * 更新菜单状态
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysMenu udpateStatus(MenuInfo menuInfo) throws Exception;
	
	
}
