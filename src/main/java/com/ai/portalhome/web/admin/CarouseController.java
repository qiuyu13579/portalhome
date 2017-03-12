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

import com.ai.portalhome.dao.model.TCarouselInfo;
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
@RequestMapping(value = "/car")
public class CarouseController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITCarouselSV iTCarouselInfoSV;
	
	/**
	 * 轮播管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		
		return "admin/car/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		
		try {
			PageInfo<TCarouselInfo> page = iTCarouselInfoSV.getCarouselList(carouseInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/car/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param carouseInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		
		try {
			PageInfo<TCarouselInfo> page = iTCarouselInfoSV.getCarouselList(carouseInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/car/datahis";
	}
	
	
	
	
	/**
	 * 展示新增轮播界面
	 * @param request
	 * @param response
	 * @param model
	 * @param carouseInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/car/add";
	}
	/**
	 * 新增轮播
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			TCarouselInfo addCarousel = iTCarouselInfoSV.addCarousel(carouseInfo);
			
			log.info("getCarouselId:"+addCarousel.getCarId());
			
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
	 * @param carouseInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			
			Integer catId = carouseInfo.getCarId();
			if(catId == null || catId == 0){
				throw new BusinessException("非法操作：无轮播编码！");
			}
			
			TCarouselInfo queryVO = iTCarouselInfoSV.getCarousel(catId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/car/edit";
	}
	/**
	 * 编辑轮播
	 * @param request
	 * @param response
	 * @param model
	 * @param carouseInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			TCarouselInfo addCarousel = iTCarouselInfoSV.editCarousel(carouseInfo);
			
			log.info("getCarouselId:"+addCarousel.getCarId());
			
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
	 * @param carouseInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			carouseInfo.setUpdateUser("testperson");
			TCarouselInfo opRs = iTCarouselInfoSV.udpateStatus(carouseInfo);
			
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
	 * @param carouseInfo
	 * @throws Exception
	 */
/*	@RequestMapping(value = "/queryCarouselList")
	@ResponseBody
	public void queryCarouselList(HttpServletRequest request, HttpServletResponse response,Model model,CarouselInfo carouseInfo) throws Exception {
		try {
			
			//设置最大展示数量
			carouseInfo.setPageNo(1);
			carouseInfo.setPageSize(1000);
			
			CarouselInfo car = iTCarouselInfoSV.queryCarouselList(carouseInfo);
			if(car != null && car.getDataList() != null){
//				this.output(response, queryCarouselList.getList());
			}else{
//				this.output(response, R.failure("没有轮播数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}*/
	
	
	
	
}
