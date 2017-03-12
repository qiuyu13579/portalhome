package com.ai.portalhome.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ai.paas.utils.CollectionUtil;
import com.ai.portalhome.common.utils.BeanUtil;
import com.ai.portalhome.common.utils.DateUtil;
import com.ai.portalhome.common.utils.ISequenceUtil;
import com.ai.portalhome.dao.mapper.TUserInfoMapper;
import com.ai.portalhome.dao.model.TUserInfo;
import com.ai.portalhome.dao.model.TUserInfoExample;
import com.ai.portalhome.service.interfaces.ITUserInfoSV;
import com.ai.portalhome.vo.UserInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TUserInfoSVImp implements ITUserInfoSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TUserInfoMapper tUserInfoMapper;
	

	@Override
	public PageInfo<TUserInfo> getUserList(UserInfo userInfo) throws Exception {
		
		PageInfo<TUserInfo> page = new PageInfo<TUserInfo>();
		
		TUserInfoExample example = new TUserInfoExample();
		TUserInfoExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = userInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//用户名称过滤
		String userName = userInfo.getUserName();
		if(userName != null && !"".equals(userName)){
			criteria.andUserNameLike("%"+userName+"%");
		}
		
		//排序
		example.setOrderByClause(" create_time asc,update_time asc ");
		
		PageHelper.startPage(userInfo.getPageNo(), userInfo.getPageSize(),true);
		List<TUserInfo> qryList = tUserInfoMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TUserInfo>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public TUserInfo getUser(Integer userId) throws Exception {
		TUserInfo vo = new TUserInfo();
		TUserInfo queryVO = tUserInfoMapper.selectByPrimaryKey(userId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public PageInfo<TUserInfo> queryUserList(UserInfo userInfo) throws Exception {
		PageInfo<TUserInfo> page = new PageInfo<TUserInfo>();
		
		TUserInfoExample example = new TUserInfoExample();
		TUserInfoExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" User_sup asc, User_Order asc");
		
		PageHelper.startPage(userInfo.getPageNo(), userInfo.getPageSize(),true);
		List<TUserInfo> qryList = tUserInfoMapper.selectByExample(example);
		
		
		
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			page = new PageInfo<TUserInfo>(qryList);
		}
		
		
		return page;
	}
	
	

	/**
	 * 新增用户
	 */
	@Override
	public TUserInfo addUser(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TUserInfo obj = new TUserInfo();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_USER_INFO");//获取序列
		
		BeanUtil.copyVO(obj, userInfo);//复制基本属性
		obj.setUserId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tUserInfoMapper.insert(obj);
		return obj;
	}
	
	@Override
	public TUserInfo editUser(UserInfo userInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TUserInfo obj = new TUserInfo();
		
		Integer userId = userInfo.getUserId();
		if(userId == null || userId == 0){
			throw new BusinessException("非法操作：无用户编码！");
		}
		
		
		BeanUtil.copyVO(obj, userInfo);//复制基本属性
		
		//设置不需要更新的字段
		userInfo.setCreateTime(null);
		userInfo.setCreateUser(null);
		userInfo.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tUserInfoMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新用户状态
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	public TUserInfo udpateStatus(UserInfo userInfo) throws Exception {
		
		TUserInfo obj = new TUserInfo();
		
		Integer userId = userInfo.getUserId();
		if(userId == null || userId == 0){
			throw new BusinessException("非法操作：无用户编码！");
		}
		String updateUser = userInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = userInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setUserId(userId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tUserInfoMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
