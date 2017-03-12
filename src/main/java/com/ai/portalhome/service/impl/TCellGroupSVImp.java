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
import com.ai.portalhome.dao.mapper.TArticleInfoMapper;
import com.ai.portalhome.dao.mapper.TCellGroupMapper;
import com.ai.portalhome.dao.model.TCellGroup;
import com.ai.portalhome.dao.model.TCellGroupExample;
import com.ai.portalhome.dao.model.TCellInfo;
import com.ai.portalhome.service.interfaces.ITCellGroupSV;
import com.ai.portalhome.service.interfaces.ITCellInfoSV;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ai.portalhome.vo.CellGroupList;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TCellGroupSVImp implements ITCellGroupSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TArticleInfoMapper tArticleInfoMapper;
	@Autowired
	private TCellGroupMapper tCellGroupMapper;
	@Autowired
	private ITCellInfoSV ITCellInfoSV;
	
	

	@Override
	public PageInfo<TCellGroup> getList(CellGroupInfo cellGroupInfo) throws Exception {
		
		PageInfo<TCellGroup> page = new PageInfo<TCellGroup>();
		
		TCellGroupExample example = new TCellGroupExample();
		TCellGroupExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = cellGroupInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//栏目标题
		String groupName = cellGroupInfo.getGroupName();
		if(groupName != null && !"".equals(groupName)){
			criteria.andGroupNameLike("%"+groupName+"%");
		}
		
		//排序
		example.setOrderByClause(" update_time desc ");
		
		PageHelper.startPage(cellGroupInfo.getPageNo(), cellGroupInfo.getPageSize(),true);
		List<TCellGroup> qryList = tCellGroupMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TCellGroup>(qryList);
		}
		
		return page;
	}
	
	@Override
	public CellGroupList getShowList(CellGroupInfo cellGroupInfo) throws Exception {
		
		CellGroupList voList = new CellGroupList();
		
		Integer groupId = cellGroupInfo.getGroupId();
		
		TCellGroup group = get(groupId);
		
		
		if(group != null ){
			voList.setGroup(group);
			//获取分组文章列表
			CellGroupInfo info = new CellGroupInfo();
			info.setGroupId(groupId);
			List<TCellInfo> allList = ITCellInfoSV.getAllList(info);
			if(!CollectionUtil.isEmpty(allList)){
				voList.setNextList(allList);
			}
		}
		return voList;
	}
	
	@Override
	public TCellGroup get(Integer id) throws Exception {
		TCellGroup vo = new TCellGroup();
		TCellGroup queryVO = tCellGroupMapper.selectByPrimaryKey(id);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TCellGroup add(CellGroupInfo cellGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCellGroup obj = new TCellGroup();
		
		Integer id = seqUtil.getNewId("SEQ_T_CELL_GROUP");//获取序列
		
		BeanUtil.copyVO(obj, cellGroupInfo);//复制基本属性
		obj.setGroupId(id);//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		
		int insert = tCellGroupMapper.insert(obj);
		
		return obj;
	}
	
	@Override
	public TCellGroup edit(CellGroupInfo cellGroupInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCellGroup obj = new TCellGroup();
		
		Integer id = cellGroupInfo.getGroupId();
		if(id == null || id == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, cellGroupInfo);//复制基本属性
		
		//设置不需要更新的字段
		obj.setCreateTime(null);
		obj.setCreateUser(null);
		obj.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tCellGroupMapper.updateByPrimaryKeySelective(obj);
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
	public TCellGroup udpateStatus(CellGroupInfo cellGroupInfo) throws Exception {
		
		TCellGroup obj = new TCellGroup();
		
		Integer id = cellGroupInfo.getGroupId();
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
		
		obj.setGroupId(id);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tCellGroupMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
