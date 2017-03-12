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
import com.ai.portalhome.dao.mapper.TCarouselDataMapper;
import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.dao.model.TCarouselDataExample;
import com.ai.portalhome.service.interfaces.ITCarouselDataSV;
import com.ai.portalhome.vo.CarouselInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TCarouselDataSVImp implements ITCarouselDataSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TCarouselDataMapper tCarouselDataMapper;
	

	@Override
	public PageInfo<TCarouselData> getCarouselDataList(CarouselInfo carouselInfo) throws Exception {
		
		PageInfo<TCarouselData> page = new PageInfo<TCarouselData>();
		
		TCarouselDataExample example = new TCarouselDataExample();
		TCarouselDataExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = carouselInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//图片标题过滤
		String carTitle = carouselInfo.getCarTitle();
		if(carTitle != null && !"".equals(carTitle)){
			criteria.andCarTitleLike("%"+carTitle+"%");
		}
		
		//排序
		example.setOrderByClause(" car_order asc ");
		
		PageHelper.startPage(carouselInfo.getPageNo(), carouselInfo.getPageSize(),true);
		List<TCarouselData> qryList = tCarouselDataMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TCarouselData>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public TCarouselData getCarouselData(Integer carId) throws Exception {
		TCarouselData vo = new TCarouselData();
		TCarouselData queryVO = tCarouselDataMapper.selectByPrimaryKey(carId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public PageInfo<TCarouselData> queryCarouselDataList(CarouselInfo carouselInfo) throws Exception {
		PageInfo<TCarouselData> page = new PageInfo<TCarouselData>();
	/*	
		TCarouselDataExample example = new TCarouselDataExample();
		TCarouselDataExample.Criteria criteria = example.createCriteria();
		
		//状态过滤
		criteria.andStatusEqualTo("1");
		
		//排序
		example.setOrderByClause(" Role_sup asc, Role_Order asc");
		
		PageHelper.startPage(carouselInfo.getPageNo(), carouselInfo.getPageSize(),true);
		List<TCarouselData> qryList = tCarouselDataMapper.selectByExample(example);
		
		
		if(!CollectionUtil.isEmpty(qryList)){
			
			page = new PageInfo<TCarouselData>(qryList);
		}*/
		
		
		return page;
	}
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TCarouselData addCarouselData(CarouselInfo carouselInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCarouselData obj = new TCarouselData();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_CAROUSEL_DATA");//获取序列
		
		BeanUtil.copyVO(obj, carouselInfo);//复制基本属性
		obj.setDataId(seqId);;//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tCarouselDataMapper.insert(obj);
		return obj;
	}
	
	@Override
	public TCarouselData editCarouselData(CarouselInfo carouselInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCarouselData obj = new TCarouselData();
		
		Integer dataId = carouselInfo.getDataId();
		if(dataId == null || dataId == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, carouselInfo);//复制基本属性
		
		//设置不需要更新的字段
		carouselInfo.setCreateTime(null);
		carouselInfo.setCreateUser(null);
		carouselInfo.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tCarouselDataMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	/**
	 * 更新角色状态
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselData udpateStatus(CarouselInfo carouselInfo) throws Exception {
		
		TCarouselData obj = new TCarouselData();
		
		Integer dataId = carouselInfo.getDataId();
		if(dataId == null || dataId == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		String updateUser = carouselInfo.getUpdateUser();
		if(updateUser == null || updateUser.equals("")){
			throw new BusinessException("非法操作：操作人账号为空！");
		}
		String status = carouselInfo.getStatus();
		if(status == null || status.equals("")){
			throw new BusinessException("非法操作：操作状态为空！");
		}
		
		obj.setDataId(dataId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tCarouselDataMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
