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
import com.ai.portalhome.dao.mapper.TSysMenuMapper;
import com.ai.portalhome.dao.mapper.TSysRole2MenuMapper;
import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.dao.model.TSysRole2Menu;
import com.ai.portalhome.dao.model.TSysRole2MenuExample;
import com.ai.portalhome.service.interfaces.ITSysRole2MenuSV;
import com.ai.portalhome.vo.RoleMenuInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TSysRole2MenuSVImp implements ITSysRole2MenuSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TSysRole2MenuMapper tSysRole2MenuMapper;
	@Autowired
	private TSysMenuMapper tSysMenuMapper;
	

	@Override
	public PageInfo<RoleMenuInfo> getRoleMenuList(RoleMenuInfo roleMenuInfo) throws Exception {
		
		PageInfo<RoleMenuInfo> page = new PageInfo<RoleMenuInfo>();
		
		TSysRole2MenuExample example = new TSysRole2MenuExample();
		TSysRole2MenuExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = roleMenuInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色菜单关系ID过滤
		Integer roleId = roleMenuInfo.getRoleId();
		if(roleId != null && roleId != 0){
			criteria.andRoleIdEqualTo(roleId);
		}
		
		//排序
		example.setOrderByClause(" create_time asc ");
		
		PageHelper.startPage(roleMenuInfo.getPageNo(), roleMenuInfo.getPageSize(),true);
		List<TSysRole2Menu> qryList = tSysRole2MenuMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			PageInfo<TSysRole2Menu> pageNew = new PageInfo<TSysRole2Menu>(qryList);
			
			List<RoleMenuInfo> qryListNew = new ArrayList<RoleMenuInfo>();
			for (int i = 0; i < qryList.size(); i++) {
				TSysRole2Menu role2Menu = qryList.get(i);
				RoleMenuInfo menuInfo = new RoleMenuInfo();
				BeanUtil.copyVO(menuInfo, role2Menu);
				
				//拼装菜单信息
				Integer menuId = role2Menu.getMenuId();
				TSysMenu tSysMenu = tSysMenuMapper.selectByPrimaryKey(menuId);
				menuInfo.setMenu(tSysMenu);
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
	public List<TSysRole2Menu> getMenuList(RoleMenuInfo roleMenuInfo) throws Exception {
		List<TSysRole2Menu> qryList = new ArrayList<TSysRole2Menu>();
		
		TSysRole2MenuExample example = new TSysRole2MenuExample();
		TSysRole2MenuExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		String status = roleMenuInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色菜单关系ID过滤
		Integer roleId = roleMenuInfo.getRoleId();
		if(roleId != null && roleId != 0){
			criteria.andRoleIdEqualTo(roleId);
		}
		
		//排序
		example.setOrderByClause(" create_time asc ");
		
		qryList = tSysRole2MenuMapper.selectByExample(example);
		
		return qryList;
	}
	
	@Override
	public PageInfo<TSysRole2Menu> queryRoleMenuList(RoleMenuInfo roleMenuInfo) throws Exception {
		PageInfo<TSysRole2Menu> page = new PageInfo<TSysRole2Menu>();
		
		TSysRole2MenuExample example = new TSysRole2MenuExample();
		TSysRole2MenuExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" Role_sup asc, Role_Order asc");
		
		PageHelper.startPage(roleMenuInfo.getPageNo(), roleMenuInfo.getPageSize(),true);
		List<TSysRole2Menu> qryList = tSysRole2MenuMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			page = new PageInfo<TSysRole2Menu>(qryList);
		}
		
		
		return page;
	}
	
	

	/**
	 * 新增角色菜单关系
	 */
	@Override
	public TSysRole2Menu addRoleMenu(RoleMenuInfo roleMenuInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TSysRole2Menu obj = new TSysRole2Menu();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_SYS_ROLE_2_MENU");//获取序列
		
		BeanUtil.copyVO(obj, roleMenuInfo);//复制基本属性
		obj.setRmId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tSysRole2MenuMapper.insert(obj);
		return obj;
	}
	
	/**
	 * 更新角色菜单关系状态
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	public TSysRole2Menu udpateStatus(RoleMenuInfo roleMenuInfo) throws Exception {
		
		TSysRole2Menu obj = new TSysRole2Menu();
		
		Integer rmId = roleMenuInfo.getRmId();
		if(rmId == null || rmId == 0){
			throw new BusinessException("非法操作：无角色菜单关系编码！");
		}
		String updateUser = roleMenuInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = roleMenuInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setRmId(rmId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tSysRole2MenuMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
