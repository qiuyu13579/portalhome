package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.vo.RoleInfo;
import com.github.pagehelper.PageInfo;


public interface ITSysRoleSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysRole> getRoleList(RoleInfo roleInfo) throws Exception;
	
	/**
	 * 新增
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole addRole(RoleInfo roleInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TSysRole getRole(Integer roleId) throws Exception;
	
	/**
	 * 查询列表 - 后台管理展示
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysRole> queryRoleList(RoleInfo roleInfo) throws Exception;
	
	/**
	 * 编辑
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole editRole(RoleInfo roleInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole udpateStatus(RoleInfo roleInfo) throws Exception;
	
	
}
