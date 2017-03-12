package com.ai.portalhome.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.service.interfaces.ITLoColumnSV;
import com.ai.portalhome.service.interfaces.ITLoMainSV;
import com.ai.portalhome.vo.LoMainInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 布局管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/loColumn")
public class LoColumnController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITLoMainSV iTLoMainSV;
	@Autowired
	private ITLoColumnSV iTLoColumnSV;
	
	/**
	 * 布局管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		Integer olId = loMainInfo.getOlId();
		if(olId != null && olId != 0){
			model.addAttribute("olId", olId);
		}
//		LoMainInfo mainInfo = iTLoMainSV.getLo(olId);
//		if(mainInfo != null){
//			model.addAttribute("lo", mainInfo);
//		}
		return "admin/loColumn/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		try {
			PageInfo<TLoColumn> page = iTLoColumnSV.getList(loMainInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/loColumn/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		try {
			PageInfo<TLoColumn> page = iTLoColumnSV.getList(loMainInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/loColumn/datahis";
	}
	
	
	
	
	/**
	 * 展示新增布局界面
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/loColumn/add";
	}
	/**
	 * 新增栏目
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			TLoColumn add = iTLoColumnSV.add(loMainInfo);
			
			log.info("getId:"+add.getColId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看栏目
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			
			Integer colId = loMainInfo.getColId();
			if(colId == null || colId == 0){
				throw new BusinessException("非法操作：无栏目编码！");
			}
			
			TLoColumn queryVO = iTLoColumnSV.get(colId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/loColumn/edit";
	}
	/**
	 * 编辑栏目
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			TLoColumn add = iTLoColumnSV.edit(loMainInfo);
			
			log.info("getId:"+add.getColId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新栏目状态
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			loMainInfo.setUpdateUser("testperson");
			TLoColumn opRs = iTLoColumnSV.udpateStatus(loMainInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
/*	*//**
	 * 查询栏目列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param loMainInfo
	 * @throws Exception
	 *//*
	@RequestMapping(value = "/queryList")
	@ResponseBody
	public void queryList(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		try {
			
			//设置最大展示数量
			loMainInfo.setPageNo(1);
			loMainInfo.setPageSize(1000);
			
			PageInfo<TLoColumn> queryList = iTLoColumnSV.queryList(loMainInfo);
			if(queryList != null && queryList.getList() != null){
				this.output(response, queryList.getList());
			}else{
				this.output(response, R.failure("没有栏目数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}*/
	
	
	
	
}
