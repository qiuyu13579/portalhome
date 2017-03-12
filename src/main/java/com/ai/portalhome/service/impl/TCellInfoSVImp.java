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
import com.ai.portalhome.dao.mapper.TCellInfoMapper;
import com.ai.portalhome.dao.model.TCellInfo;
import com.ai.portalhome.dao.model.TCellInfoExample;
import com.ai.portalhome.service.interfaces.ITCellInfoSV;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TCellInfoSVImp implements ITCellInfoSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TCellInfoMapper tCellInfoMapper;
	

	@Override
	public PageInfo<TCellInfo> getList(CellGroupInfo cellGroupInfo) throws Exception {
		
		PageInfo<TCellInfo> page = new PageInfo<TCellInfo>();
		
		TCellInfoExample example = new TCellInfoExample();
		TCellInfoExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = cellGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
//		String groupName = cellGroupInfo.getGroupName();
//		if(groupName != null && !"".equals(groupName)){
//			criteria.andGroupNameLike("%"+groupName+"%");
//		}
		
		Integer groupId = cellGroupInfo.getGroupId();
		criteria.andGroupIdEqualTo(groupId);
		
		//排序
		example.setOrderByClause(" update_time desc ");
		
		PageHelper.startPage(cellGroupInfo.getPageNo(), cellGroupInfo.getPageSize(),true);
		List<TCellInfo> qryList = tCellInfoMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TCellInfo>(qryList);
		}
		
		return page;
	}
	
	@Override
	public List<TCellInfo> getAllList(CellGroupInfo cellGroupInfo) throws Exception {
		
		List<TCellInfo> list = new ArrayList<TCellInfo>();
		
		TCellInfoExample example = new TCellInfoExample();
		TCellInfoExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = cellGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//获取分组文章列表
		Integer groupId = cellGroupInfo.getGroupId();
		criteria.andGroupIdEqualTo(groupId);
		
		//排序
		example.setOrderByClause(" cel_order asc ");
		
		list = tCellInfoMapper.selectByExample(example);
		return list;
	}
	
	@Override
	public TCellInfo get(Integer id) throws Exception {
		TCellInfo vo = new TCellInfo();
		TCellInfo queryVO = tCellInfoMapper.selectByPrimaryKey(id);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	

	/**
	 * 新增角色
	 */
	@Override
	public TCellInfo add(CellGroupInfo cellGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCellInfo obj = new TCellInfo();
		
		Integer id = seqUtil.getNewId("SEQ_T_CELL_INFO");//获取序列
		
		BeanUtil.copyVO(obj, cellGroupInfo);//复制基本属性
		obj.setCelId(id);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		
		int insert = tCellInfoMapper.insert(obj);
		
		return obj;
	}
	
	@Override
	public TCellInfo edit(CellGroupInfo cellGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCellInfo obj = new TCellInfo();
		
		Integer id = cellGroupInfo.getCelId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, cellGroupInfo);//复制基本属性
		
		//设置不需要更新的字段
		obj.setCreateTime(null);
		obj.setCreateUser(null);
		obj.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tCellInfoMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	public TCellInfo udpateStatus(CellGroupInfo cellGroupInfo) throws Exception {
		
		TCellInfo obj = new TCellInfo();
		
		Integer id = cellGroupInfo.getCelId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		String updateUser = cellGroupInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = cellGroupInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setCelId(id);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tCellInfoMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
