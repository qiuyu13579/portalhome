package com.ai.portalhome.service.impl;

import java.util.ArrayList;
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
import com.ai.portalhome.dao.mapper.TSysRole2UserMapper;
import com.ai.portalhome.dao.mapper.TSysRoleMapper;
import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRole2User;
import com.ai.portalhome.dao.model.TSysRole2UserExample;
import com.ai.portalhome.service.interfaces.ITSysRole2UserSV;
import com.ai.portalhome.vo.RoleUserInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TSysRole2UserSVImp implements ITSysRole2UserSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TSysRole2UserMapper tSysRole2UserMapper;
	@Autowired
	private TSysRoleMapper tSysRoleMapper;
	

	@Override
	public PageInfo<RoleUserInfo> getRoleUserList(RoleUserInfo roleUserInfo) throws Exception {
		
		PageInfo<RoleUserInfo> page = new PageInfo<RoleUserInfo>();
		
		TSysRole2UserExample example = new TSysRole2UserExample();
		TSysRole2UserExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = roleUserInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色菜单关系ID过滤
		Integer userId = roleUserInfo.getUserId();
		if(userId != null && userId != 0){
			criteria.andUserIdEqualTo(userId);
		}
		
		//排序
		example.setOrderByClause(" create_time asc ");
		
		PageHelper.startPage(roleUserInfo.getPageNo(), roleUserInfo.getPageSize(),true);
		List<TSysRole2User> qryList = tSysRole2UserMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			PageInfo<TSysRole2User> pageNew = new PageInfo<TSysRole2User>(qryList);
			
			List<RoleUserInfo> qryListNew = new ArrayList<RoleUserInfo>();
			for (int i = 0; i < qryList.size(); i++) {
				TSysRole2User role2User = qryList.get(i);
				RoleUserInfo menuInfo = new RoleUserInfo();
				BeanUtil.copyVO(menuInfo, role2User);
				
				//拼装菜单信息
				Integer roleId = role2User.getRoleId();
				TSysRole tSysRole = tSysRoleMapper.selectByPrimaryKey(roleId);
				menuInfo.setRole(tSysRole);
				qryListNew.add(menuInfo);
			}
			page.setList(qryListNew);
			page.setPageNum(pageNew.getPageNum());
			page.setPageSize(pageNew.getPageSize());
			page.setTotal(pageNew.getTotal());
		}
		return page;
	}
	
	@Override
	public List<TSysRole2User> getRoleList(RoleUserInfo roleUserInfo) throws Exception {
		List<TSysRole2User> qryList = new ArrayList<TSysRole2User>();
		
		TSysRole2UserExample example = new TSysRole2UserExample();
		TSysRole2UserExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		String status = roleUserInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//用户过滤
		Integer userId = roleUserInfo.getUserId();
		if(userId != null && userId != 0){
			criteria.andUserIdEqualTo(userId);
		}
		
		//排序
		example.setOrderByClause(" create_time asc ");
		
		qryList = tSysRole2UserMapper.selectByExample(example);
		
		return qryList;
	}
	
	@Override
	public PageInfo<TSysRole2User> queryRoleUserList(RoleUserInfo roleUserInfo) throws Exception {
		PageInfo<TSysRole2User> page = new PageInfo<TSysRole2User>();
		
		TSysRole2UserExample example = new TSysRole2UserExample();
		TSysRole2UserExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" Role_sup asc, Role_Order asc");
		
		PageHelper.startPage(roleUserInfo.getPageNo(), roleUserInfo.getPageSize(),true);
		List<TSysRole2User> qryList = tSysRole2UserMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			page = new PageInfo<TSysRole2User>(qryList);
		}
		
		
		return page;
	}
	
	

	/**
	 * 新增角色菜单关系
	 */
	@Override
	public TSysRole2User addRoleUser(RoleUserInfo roleUserInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysRole2User obj = new TSysRole2User();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_SYS_ROLE_2_USER");//获取序列
		
		BeanUtil.copyVO(obj, roleUserInfo);//复制基本属性
		obj.setRuId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tSysRole2UserMapper.insert(obj);
		return obj;
	}
	
	/**
	 * 更新角色菜单关系状态
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2User udpateStatus(RoleUserInfo roleUserInfo) throws Exception {
		
		TSysRole2User obj = new TSysRole2User();
		
		Integer ruId = roleUserInfo.getRuId();
		if(ruId == null || ruId == 0){
			throw new BusinessException("非法操作：无角色菜单关系编码！");
		}
		String updateUser = roleUserInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = roleUserInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setRuId(ruId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tSysRole2UserMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	

}
