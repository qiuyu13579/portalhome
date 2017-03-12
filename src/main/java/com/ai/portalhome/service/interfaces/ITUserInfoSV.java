package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TUserInfo;
import com.ai.portalhome.vo.UserInfo;
import com.github.pagehelper.PageInfo;


public interface ITUserInfoSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TUserInfo> getUserList(UserInfo userInfo) throws Exception;
	
	/**
	 * 新增
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public TUserInfo addUser(UserInfo userInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TUserInfo getUser(Integer userId) throws Exception;
	
	/**
	 * 查询列表 - 后台管理展示
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TUserInfo> queryUserList(UserInfo userInfo) throws Exception;
	
	/**
	 * 编辑
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public TUserInfo editUser(UserInfo userInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public TUserInfo udpateStatus(UserInfo userInfo) throws Exception;
	
	
}
