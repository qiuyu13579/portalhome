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
import com.ai.portalhome.dao.mapper.TCarouselInfoMapper;
import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.dao.model.TCarouselDataExample;
import com.ai.portalhome.dao.model.TCarouselInfo;
import com.ai.portalhome.dao.model.TCarouselInfoExample;
import com.ai.portalhome.service.interfaces.ITCarouselSV;
import com.ai.portalhome.vo.CarouselInfo;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional
public class TCarouselSVImp implements ITCarouselSV{
	
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	@Autowired
	private ISequenceUtil seqUtil;
	@Autowired
	private TCarouselInfoMapper tCarouselInfoMapper;
	@Autowired
	private TCarouselDataMapper tCarouselDataMapper;
	

	@Override
	public PageInfo<TCarouselInfo> getCarouselList(CarouselInfo carouselInfo) throws Exception {
		
		PageInfo<TCarouselInfo> page = new PageInfo<TCarouselInfo>();
		
		TCarouselInfoExample example = new TCarouselInfoExample();
		TCarouselInfoExample.Criteria criteria = example.createCriteria();
		
		
		//状态过滤
		String status = carouselInfo.getStatus();
		if(status == null || "".equals(status)){
			criteria.andStatusEqualTo("1");
		}else{
			criteria.andStatusEqualTo(status);
		}
		//角色名称过滤
//		String userName = carouselInfo.getRoleName();
//		if(userName != null && !"".equals(userName)){
//			criteria.andRoleNameLike("%"+userName+"%");
//		}
		
		//排除角色
//		List<Integer> roleList = carouselInfo.getRoleList();
//		if(!CollectionUtil.isEmpty(roleList)){
//			criteria.andRoleIdNotIn(roleList);
//		}
		//排序
		example.setOrderByClause(" create_time asc ");
		
		PageHelper.startPage(carouselInfo.getPageNo(), carouselInfo.getPageSize(),true);
		List<TCarouselInfo> qryList = tCarouselInfoMapper.selectByExample(example);
		
		if(!CollectionUtil.isEmpty(qryList)){
			page = new PageInfo<TCarouselInfo>(qryList);
		}
		
		
		return page;
	}
	
	@Override
	public TCarouselInfo getCarousel(Integer carId) throws Exception {
		TCarouselInfo vo = new TCarouselInfo();
		TCarouselInfo queryVO = tCarouselInfoMapper.selectByPrimaryKey(carId);
		if(queryVO != null){
			vo = queryVO;
		}
		return vo;
	}
	
	@Override
	public CarouselInfo queryCarouselList(CarouselInfo carouselInfo) throws Exception {
		
		CarouselInfo car = new CarouselInfo();
		//轮播ID
		Integer carId = carouselInfo.getCarId();
		
		TCarouselInfo tCarouselInfo = tCarouselInfoMapper.selectByPrimaryKey(carId);
		if(tCarouselInfo != null){
			BeanUtil.copyVO(car, tCarouselInfo);
			TCarouselDataExample example = new TCarouselDataExample();
			TCarouselDataExample.Criteria criteria = example.createCriteria();
			
			
			criteria.andCarIdEqualTo(carId);
			//状态过滤
			criteria.andStatusEqualTo("1");
			
			//排序
			example.setOrderByClause(" car_order asc");
			
			PageHelper.startPage(carouselInfo.getPageNo(), carouselInfo.getPageSize(),true);
			List<TCarouselData> qryList = tCarouselDataMapper.selectByExample(example);
			
			if(!CollectionUtil.isEmpty(qryList)){
				car.setDataList(qryList);
			}
		}
		return car;
	}
	
	

	/**
	 * 新增角色
	 */
	@Override
	public TCarouselInfo addCarousel(CarouselInfo carouselInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCarouselInfo obj = new TCarouselInfo();
		
		Integer seqId = seqUtil.getNewId("SEQ_T_CAROUSEL_INFO");//获取序列
		
		BeanUtil.copyVO(obj, carouselInfo);//复制基本属性
		obj.setCarId(seqId);;//设置主键
		obj.setCreateTime(DateUtil.getDate());
		obj.setStatus("1");
		int insert = tCarouselInfoMapper.insert(obj);
		return obj;
	}
	
	@Override
	public TCarouselInfo editCarousel(CarouselInfo carouselInfo) throws Exception {
		// TODO Auto-generated method stub
		
		TCarouselInfo obj = new TCarouselInfo();
		
		Integer carId = carouselInfo.getCarId();
		if(carId == null || carId == 0){
			throw new BusinessException("非法操作：无主键编码！");
		}
		
		
		BeanUtil.copyVO(obj, carouselInfo);//复制基本属性
		
		//设置不需要更新的字段
		carouselInfo.setCreateTime(null);
		carouselInfo.setCreateUser(null);
		carouselInfo.setStatus(null);
		
		obj.setUpdateTime(DateUtil.getDate());
		
		int updateByPrimaryKeySelective = tCarouselInfoMapper.updateByPrimaryKeySelective(obj);
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
	public TCarouselInfo udpateStatus(CarouselInfo carouselInfo) throws Exception {
		
		TCarouselInfo obj = new TCarouselInfo();
		
		Integer carId = carouselInfo.getCarId();
		if(carId == null || carId == 0){
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
		
		obj.setCarId(carId);
		obj.setUpdateTime(DateUtil.getDate());
		obj.setUpdateUser(updateUser);
		obj.setStatus(status);
		
		int updateByPrimaryKeySelective = tCarouselInfoMapper.updateByPrimaryKeySelective(obj);
		if(updateByPrimaryKeySelective != 1){
			throw new BusinessException("更新失败！");
		}
		return obj;
	}
	
	
	
	

}
