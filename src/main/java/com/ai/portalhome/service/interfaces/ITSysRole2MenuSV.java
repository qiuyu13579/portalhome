package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TSysRole2Menu;
import com.ai.portalhome.vo.RoleMenuInfo;
import com.github.pagehelper.PageInfo;


public interface ITSysRole2MenuSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<RoleMenuInfo> getRoleMenuList(RoleMenuInfo roleMenuInfo) throws Exception;
	
	/**
	 * 根据角色获取所有菜单列表 - 简约数据
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	public List<TSysRole2Menu> getMenuList(RoleMenuInfo roleMenuInfo) throws Exception;
	
	/**
	 * 新增
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2Menu addRoleMenu(RoleMenuInfo roleMenuInfo) throws Exception;
	
	/**
	 * 查询列表 - 后台管理展示
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysRole2Menu> queryRoleMenuList(RoleMenuInfo roleMenuInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2Menu udpateStatus(RoleMenuInfo roleMenuInfo) throws Exception;
	
	
}
