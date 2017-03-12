package com.ai.portalhome.service.interfaces;

import com.ai.portalhome.dao.model.TCarouselInfo;
import com.ai.portalhome.vo.CarouselInfo;
import com.github.pagehelper.PageInfo;


public interface ITCarouselSV {
	
	/**
	 * 获取列表
	 * 
	 * @return
	 * @throws Exception
	 */
	public PageInfo<TCarouselInfo> getCarouselList(CarouselInfo carouselInfo) throws Exception;
	
	/**
	 * 新增
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselInfo addCarousel(CarouselInfo carouselInfo) throws Exception;
	
	/**
	 * 查询单个信息
	 * 
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public TCarouselInfo getCarousel(Integer carId) throws Exception;
	
	/**
	 * 查询列表 - 轮播界面查询
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	public CarouselInfo queryCarouselList(CarouselInfo carouselInfo) throws Exception;
	
	/**
	 * 编辑
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselInfo editCarousel(CarouselInfo carouselInfo) throws Exception;
	
	
	/**
	 * 更新状态
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	public TCarouselInfo udpateStatus(CarouselInfo carouselInfo) throws Exception;
	
	
	
}
