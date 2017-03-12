package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.vo.CarouselInfo;
import com.github.pagehelper.PageInfo;


public interface ITCarouselDataSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TCarouselData> getCarouselDataList(CarouselInfo carouseInfo) throws Exception;
	
	/**
	 * 新增
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselData addCarouselData(CarouselInfo carouseInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TCarouselData getCarouselData(Integer carId) throws Exception;
	
	/**
	 * 查询列表 - 后台管理展示
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TCarouselData> queryCarouselDataList(CarouselInfo carouseInfo) throws Exception;
	
	/**
	 * 编辑
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselData editCarouselData(CarouselInfo carouseInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselData udpateStatus(CarouselInfo carouseInfo) throws Exception;
	
	
}
