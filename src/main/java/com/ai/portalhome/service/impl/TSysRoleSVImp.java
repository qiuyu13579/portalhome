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
import com.ai.portalhome.dao.mapper.TSysRoleMapper;
import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRoleExample;
import com.ai.portalhome.service.interfaces.ITSysRoleSV;
import com.ai.portalhome.vo.RoleInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TSysRoleSVImp implements ITSysRoleSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TSysRoleMapper tSysRoleMapper;
	

	@Override
	public PageInfo<TSysRole> getRoleList(RoleInfo roleInfo) throws Exception {
		
		PageInfo<TSysRole> page = new PageInfo<TSysRole>();
		
		TSysRoleExample example = new TSysRoleExample();
		TSysRoleExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = roleInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色名称过滤
		String userName = roleInfo.getRoleName();
		if(userName != null && !"".equals(userName)){
			criteria.andRoleNameLike("%"+userName+"%");
		}
		
		//排除角色
		List<Integer> roleList = roleInfo.getRoleList();
		if(!CollectionUtil.isEmpty(roleList)){
			criteria.andRoleIdNotIn(roleList);
		}
		//排序
		example.setOrderByClause(" role_order asc ");
		
		PageHelper.startPage(roleInfo.getPageNo(), roleInfo.getPageSize(),true);
		List<TSysRole> qryList = tSysRoleMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TSysRole>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public TSysRole getRole(Integer roleId) throws Exception {
		TSysRole vo = new TSysRole();
		TSysRole queryVO = tSysRoleMapper.selectByPrimaryKey(roleId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public PageInfo<TSysRole> queryRoleList(RoleInfo roleInfo) throws Exception {
		PageInfo<TSysRole> page = new PageInfo<TSysRole>();
		
		TSysRoleExample example = new TSysRoleExample();
		TSysRoleExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" Role_sup asc, Role_Order asc");
		
		PageHelper.startPage(roleInfo.getPageNo(), roleInfo.getPageSize(),true);
		List<TSysRole> qryList = tSysRoleMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			page = new PageInfo<TSysRole>(qryList);
		}
		
		
		return page;
	}
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TSysRole addRole(RoleInfo roleInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysRole obj = new TSysRole();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_SYS_ROLE");//获取序列
		
		BeanUtil.copyVO(obj, roleInfo);//复制基本属性
		obj.setRoleId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tSysRoleMapper.insert(obj);
		return obj;
	}
	
	@Override
	public TSysRole editRole(RoleInfo roleInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysRole obj = new TSysRole();
		
		Integer userId = roleInfo.getRoleId();
		if(userId == null || userId == 0){
			throw new BusinessException("非法操作：无角色编码！");
		}
		
		
		BeanUtil.copyVO(obj, roleInfo);//复制基本属性
		
		//设置不需要更新的字段
		roleInfo.setCreateTime(null);
		roleInfo.setCreateUser(null);
		roleInfo.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tSysRoleMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole udpateStatus(RoleInfo roleInfo) throws Exception {
		
		TSysRole obj = new TSysRole();
		
		Integer userId = roleInfo.getRoleId();
		if(userId == null || userId == 0){
			throw new BusinessException("非法操作：无角色编码！");
		}
		String updateUser = roleInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = roleInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setRoleId(userId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tSysRoleMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
