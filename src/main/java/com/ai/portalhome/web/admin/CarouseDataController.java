package com.ai.portalhome.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.portalhome.dao.model.TCarouselData;
import com.ai.portalhome.dao.model.TCarouselInfo;
import com.ai.portalhome.service.interfaces.ITCarouselDataSV;
import com.ai.portalhome.service.interfaces.ITCarouselSV;
import com.ai.portalhome.vo.CarouselInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 轮播管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/carData")
public class CarouseDataController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITCarouselSV iTCarouselSV;
	@Autowired
	private ITCarouselDataSV iTCarouselDataSV;
	
	/**
	 * 轮播管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		
		Integer carId = carouselInfo.getCarId();
		if(carId == null || carId == 0){
			throw new BusinessException("轮播编码为空");
		}
		TCarouselInfo carousel = iTCarouselSV.getCarousel(carId);
		if(carousel != null){
			model.addAttribute("car", carousel);
		}
		return "admin/car/data/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		
		try {
			PageInfo<TCarouselData> page = iTCarouselDataSV.getCarouselDataList(carouselInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/car/data/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		
		try {
			PageInfo<TCarouselData> page = iTCarouselDataSV.getCarouselDataList(carouselInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/car/data/datahis";
	}
	
	
	
	
	/**
	 * 展示新增轮播界面
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/car/data/add";
	}
	/**
	 * 新增轮播
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			TCarouselData addCarouselData = iTCarouselDataSV.addCarouselData(carouselInfo);
			
			log.info("getCarouselDataId:"+addCarouselData.getCarId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看轮播
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			
			Integer dataId = carouselInfo.getDataId();
			if(dataId == null || dataId == 0){
				throw new BusinessException("非法操作：无轮播编码！");
			}
			
			TCarouselData queryVO = iTCarouselDataSV.getCarouselData(dataId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/car/data/edit";
	}
	/**
	 * 编辑轮播
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			TCarouselData addCarouselData = iTCarouselDataSV.editCarouselData(carouselInfo);
			
			log.info("getCarouselDataId:"+addCarouselData.getCarId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新轮播状态
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			carouselInfo.setUpdateUser("testperson");
			TCarouselData opRs = iTCarouselDataSV.udpateStatus(carouselInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询轮播列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param carouselInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryCarouselDataList")
	@ResponseBody
	public void queryCarouselDataList(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouselInfo) throws Exception {
		try {
			
			//设置最大展示数量
			carouselInfo.setPageNo(1);
			carouselInfo.setPageSize(1000);
			
			PageInfo<TCarouselData> queryCarouselDataList = iTCarouselDataSV.queryCarouselDataList(carouselInfo);
			if(queryCarouselDataList != null && queryCarouselDataList.getList() != null){
				this.output(response, queryCarouselDataList.getList());
			}else{
				this.output(response, R.failure("没有轮播数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
	
	
}
