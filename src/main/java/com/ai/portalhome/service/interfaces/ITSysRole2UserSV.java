package com.ai.portalhome.service.interfaces;

import java.util.List;

import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRole2User;
import com.ai.portalhome.vo.RoleUserInfo;
import com.github.pagehelper.PageInfo;


public interface ITSysRole2UserSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<RoleUserInfo> getRoleUserList(RoleUserInfo roleUserInfo) throws Exception;
	
	/**
	 * 根据角色获取所有用户列表 - 简约数据
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	public List<TSysRole2User> getRoleList(RoleUserInfo roleUserInfo) throws Exception;
	
	/**
	 * 新增
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2User addRoleUser(RoleUserInfo roleUserInfo) throws Exception;
	
	/**
	 * 查询列表 - 后台管理展示
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TSysRole2User> queryRoleUserList(RoleUserInfo roleUserInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2User udpateStatus(RoleUserInfo roleUserInfo) throws Exception;
	
	
}
