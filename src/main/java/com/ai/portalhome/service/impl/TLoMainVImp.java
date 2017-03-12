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
import com.ai.portalhome.dao.mapper.TLoColumnDataMapper;
import com.ai.portalhome.dao.mapper.TLoColumnMapper;
import com.ai.portalhome.dao.mapper.TLoMainMapper;
import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.dao.model.TLoColumnData;
import com.ai.portalhome.dao.model.TLoColumnDataExample;
import com.ai.portalhome.dao.model.TLoColumnExample;
import com.ai.portalhome.dao.model.TLoMain;
import com.ai.portalhome.dao.model.TLoMainExample;
import com.ai.portalhome.service.interfaces.ITLoMainSV;
import com.ai.portalhome.vo.CustomInfo;
import com.ai.portalhome.vo.LoMainInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TLoMainVImp implements ITLoMainSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TLoMainMapper loMainMapper;
	@Autowired
	private TLoColumnDataMapper loColumnDataMapper;
	@Autowired
	private TLoColumnMapper loColumnMapper;
	

	@Override
	public PageInfo<TLoMain> getLoList(LoMainInfo loMainInfo) throws Exception {
		
		PageInfo<TLoMain> page = new PageInfo<TLoMain>();
		
		TLoMainExample example = new TLoMainExample();
		TLoMainExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = loMainInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色名称过滤
		String olName = loMainInfo.getOlName();
		if(olName != null && !"".equals(olName)){
			criteria.andOlNameLike("%"+olName+"%");
		}
		//排序
		example.setOrderByClause(" update_time desc ");
		
		PageHelper.startPage(loMainInfo.getPageNo(), loMainInfo.getPageSize(),true);
		List<TLoMain> qryList = loMainMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TLoMain>(qryList);
		}
		return page;
	}
	
	/**
	 * 新增角色
	 */
	@Override
	public LoMainInfo addLo(LoMainInfo loMainInfo) throws Exception {
		// TODO Auto-generated method stub
		
		LoMainInfo obj = new LoMainInfo();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_SYS_ROLE");//获取序列
		
		BeanUtil.copyVO(obj, loMainInfo);//复制基本属性
//		obj.setLoId(seqId);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
//		int insert = loMainMapper.insert(obj);
		return obj;
	}
	
	@Override
	public LoMainInfo getLo(Integer olId) throws Exception {
		LoMainInfo vo = new LoMainInfo();
		
		TLoMain loMain = loMainMapper.selectByPrimaryKey(olId);
		if(loMain != null){
			BeanUtil.copyVO(vo, loMain);
			
			List<LoMainInfo> listMain = new ArrayList<LoMainInfo>();
			
			List<TLoColumn> listColumn = getListOfTLoColumn(olId);
			if(!CollectionUtil.isEmpty(listColumn)){
				for (int i = 0; i < listColumn.size(); i++) {
					LoMainInfo vo_ = new LoMainInfo();
					BeanUtil.copyVO(vo_, listColumn.get(i));
					
					//获取栏目数据
					TLoColumnData columnData = getTLoColumnData(listColumn.get(i).getColId());
					if(columnData != null){
						BeanUtil.copyVO(vo_, columnData);
						listMain.add(vo_);
					}
				}
			}
			vo.setListMain(listMain);
			
		}
		return vo;
	}
	
	@Override
	public LoMainInfo editLoColumn(LoMainInfo loMainInfo) throws Exception {
		// TODO Auto-generated method stub
		
		List<TLoColumn> qryList = loMainInfo.getListColumn();
		if(!CollectionUtil.isEmpty(qryList)){
			for(TLoColumn column : qryList){
				Integer colId = column.getColId();
				
				TLoColumn col = new TLoColumn();
				
				col.setUpdateTime(DateUtil.getDate());
				col.setUpdateUser(loMainInfo.getUpdateUser());
				col.setColX(column.getColX());
				col.setColY(column.getColY());
				col.setColHeigh(column.getColHeigh());
				col.setColWidth(column.getColWidth());
				col.setColId(colId);
				
				int updateByPrimaryKeySelective = loColumnMapper.updateByPrimaryKeySelective(col);
				if(updateByPrimaryKeySelective != 1){
					throw new BusinessException("更新失败！");
				}
				
			}
		}
		
		return loMainInfo;
	}
	
	
	@Override
	public CustomInfo getColumn(CustomInfo customInfo) throws Exception {
		// TODO Auto-generated method stub
		TLoColumn loColumn = loColumnMapper.selectByPrimaryKey(customInfo.getColId());
		if(loColumn != null){
			customInfo.setColumn(loColumn);
			TLoColumnData columnData = getTLoColumnData(loColumn.getColId());
			if(columnData != null){
				customInfo.setColumnData(columnData);
			}
		}
		return customInfo;
	}
	
	
	

	

	
	@Override
	public PageInfo<LoMainInfo> queryLoList(LoMainInfo loMainInfo) throws Exception {
		PageInfo<LoMainInfo> page = new PageInfo<LoMainInfo>();
		
		TLoMainExample example = new TLoMainExample();
		TLoMainExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" Lo_sup asc, Lo_Order asc");
		
		PageHelper.startPage(loMainInfo.getPageNo(), loMainInfo.getPageSize(),true);
		List<TLoMain> qryList = loMainMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
//			page = new PageInfo<TLoMain>(qryList);
		}
		
		
		return page;
	}
	
	

	
	
	
	
	@Override
	public LoMainInfo editLo(LoMainInfo loMainInfo) throws Exception {
		// TODO Auto-generated method stub
		
		LoMainInfo obj = new LoMainInfo();
		
//		Integer userId = loMainInfo.getLoId();
//		if(userId == null || userId == 0){
//			throw new BusinessException("非法操作：无角色编码！");
//		}
		
		
		BeanUtil.copyVO(obj, loMainInfo);//复制基本属性
		
		//设置不需要更新的字段
		loMainInfo.setCreateTime(null);
		loMainInfo.setCreateUser(null);
		loMainInfo.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
//		int updateByPrimaryKeySelective = loMainMapper.updateByPrimaryKeySelective(obj);
//		if(updateByPrimaryKeySelective != 1){
//			throw new BusinessException("更新失败！");
//		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	public LoMainInfo udpateStatus(LoMainInfo loMainInfo) throws Exception {
		
		LoMainInfo obj = new LoMainInfo();
		
//		Integer userId = loMainInfo.getLoId();
//		if(userId == null || userId == 0){
//			throw new BusinessException("非法操作：无角色编码！");
//		}
		String updateUser = loMainInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = loMainInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
//		obj.setLoId(userId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
//		int updateByPrimaryKeySelective = loMainMapper.updateByPrimaryKeySelective(obj);
//		if(updateByPrimaryKeySelective != 1){
//			throw new BusinessException("更新失败！");
//		}
		return obj;
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * 获取栏目列表
	 * @param olId
	 * @return
	 * @throws Exception
	 */
	public List<TLoColumn>  getListOfTLoColumn(Integer olId) throws Exception {
		List<TLoColumn> qryList = new ArrayList<TLoColumn>();
		
		TLoColumnExample example = new TLoColumnExample();
		TLoColumnExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		criteria.andOlIdEqualTo(olId);
		
		//排序
		example.setOrderByClause(" create_time asc ");
		
		qryList = loColumnMapper.selectByExample(example);
		return qryList;
	}
	
	/**
	 * 获取栏目数据
	 * @param colId
	 * @return
	 * @throws Exception
	 */
	public TLoColumnData  getTLoColumnData(Integer colId) throws Exception {
		TLoColumnData data = new TLoColumnData();
//		List<TLoColumnData> qryList = new ArrayList<TLoColumnData>();
		
		TLoColumnDataExample example = new TLoColumnDataExample();
		TLoColumnDataExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		criteria.andColIdEqualTo(colId);
		
		//排序
		example.setOrderByClause(" create_time asc ");
		List<TLoColumnData> qryList  = loColumnDataMapper.selectByExample(example);
		if(!CollectionUtil.isEmpty(qryList)){
			data = qryList.get(0);
		}
		return data;
	}

	
	
	
	

}
