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
import com.ai.portalhome.dao.mapper.TLoColumnDataMapper;
import com.ai.portalhome.dao.mapper.TLoColumnMapper;
import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.dao.model.TLoColumnData;
import com.ai.portalhome.dao.model.TLoColumnExample;
import com.ai.portalhome.service.interfaces.ITLoColumnSV;
import com.ai.portalhome.vo.LoMainInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TLoColumnSVImp implements ITLoColumnSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TLoColumnMapper tLoColumnMapper;
	@Autowired
	private TLoColumnDataMapper tLoColumnDataMapper;
	

	@Override
	public PageInfo<TLoColumn> getList(LoMainInfo loMainInfo) throws Exception {
		
		PageInfo<TLoColumn> page = new PageInfo<TLoColumn>();
		
		TLoColumnExample example = new TLoColumnExample();
		TLoColumnExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = loMainInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
		String colTitle = loMainInfo.getColTitle();
		if(colTitle != null && !"".equals(colTitle)){
			criteria.andColTitleLike("%"+colTitle+"%");
		}
		Integer olId = loMainInfo.getOlId();
		if(olId != null && olId != 0){
			criteria.andOlIdEqualTo(olId);
		}
		
		//排序
		example.setOrderByClause(" col_order asc ");
		
		PageHelper.startPage(loMainInfo.getPageNo(), loMainInfo.getPageSize(),true);
		List<TLoColumn> qryList = tLoColumnMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TLoColumn>(qryList);
		}
		
		return page;
	}
	
	@Override
	public TLoColumn get(Integer carId) throws Exception {
		TLoColumn vo = new TLoColumn();
		TLoColumn queryVO = tLoColumnMapper.selectByPrimaryKey(carId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TLoColumn add(LoMainInfo loMainInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TLoColumn obj = new TLoColumn();
		
		Integer colId = seqUtil.getNewId("SEQ_T_LO_COLUMN");//获取序列
		
		BeanUtil.copyVO(obj, loMainInfo);//复制基本属性
		obj.setColId(colId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		obj.setIfEdit("1");
		
		int insert = tLoColumnMapper.insert(obj);
		
		
		//拼装栏目数据
		loMainInfo.setColId(colId);
		String colType = loMainInfo.getColType();
		TLoColumnData tLoColumnData = new TLoColumnData();
		BeanUtil.copyVO(tLoColumnData, loMainInfo);
		addData(tLoColumnData);
		
		return obj;
	}
	
	/**
	 * 新增栏目数据
	 * @param tLoColumnData
	 * @return
	 * @throws Exception
	 */
	private TLoColumnData addData(TLoColumnData tLoColumnData)throws Exception {
		// TODO Auto-generated method stub
		
		TLoColumnData obj = new TLoColumnData();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_LO_COLUMN_DATA");//获取序列
		
		BeanUtil.copyVO(obj, tLoColumnData);//复制基本属性
		obj.setDataId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		obj.setIfEdit("1");
		int insert = tLoColumnDataMapper.insert(obj);
		
		return obj;
	}
	
	
	
	
	@Override
	public TLoColumn edit(LoMainInfo loMainInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TLoColumn obj = new TLoColumn();
		
		Integer colId = loMainInfo.getDataId();
		if(colId == null || colId == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, loMainInfo);//复制基本属性
		
		//设置不需要更新的字段
		obj.setCreateTime(null);
		obj.setCreateUser(null);
		obj.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tLoColumnMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public TLoColumn udpateStatus(LoMainInfo loMainInfo) throws Exception {
		
		TLoColumn obj = new TLoColumn();
		
		Integer colId = loMainInfo.getColId();
		if(colId == null || colId == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		String updateUser = loMainInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = loMainInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setColId(colId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tLoColumnMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
