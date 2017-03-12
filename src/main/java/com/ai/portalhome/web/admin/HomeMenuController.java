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

import com.ai.portalhome.dao.model.THomeMenu;
import com.ai.portalhome.service.interfaces.ITHomeMenuSV;
import com.ai.portalhome.vo.HomeMenuInfo;
import com.ai.portalhome.vo.HomeMenuList;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 首页菜单管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/homeMenu")
public class HomeMenuController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITHomeMenuSV iTHomeMenuSV;
	
	/**
	 * 菜单管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		
		try {
//			PageInfo<THomeMenu> page = iTHomeMenuSV.getMenuList(homeMenuInfo);
			
//			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/homeMenu/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		
		try {
			PageInfo<THomeMenu> page = iTHomeMenuSV.getHomeMenuList(homeMenuInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/homeMenu/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		
		try {
			PageInfo<THomeMenu> page = iTHomeMenuSV.getHomeMenuList(homeMenuInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/homeMenu/datahis";
	}
	
	
	
	
	/**
	 * 展示新增菜单界面
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			
			Integer modelId = homeMenuInfo.getModelId();
			if(modelId == null || modelId == 0){
				throw new BusinessException("非法操作：无模块编码！");
			}
			model.addAttribute("modelId", modelId);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/homeMenu/add";
	}
	/**
	 * 新增菜单
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			THomeMenu addMenu = iTHomeMenuSV.addHomeMenu(homeMenuInfo);
			
			log.info("getMenuId:"+addMenu.getMenuId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看菜单
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			
			Integer menuId = homeMenuInfo.getMenuId();
			if(menuId == null || menuId == 0){
				throw new BusinessException("非法操作：无菜单编码！");
			}
			
			THomeMenu queryVO = iTHomeMenuSV.getHomeMenu(menuId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/homeMenu/edit";
	}
	/**
	 * 编辑菜单
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			THomeMenu addMenu = iTHomeMenuSV.editHomeMenu(homeMenuInfo);
			
			log.info("getMenuId:"+addMenu.getMenuId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新菜单状态
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			homeMenuInfo.setUpdateUser("testperson");
			THomeMenu opRs = iTHomeMenuSV.udpateStatus(homeMenuInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询菜单列表 - 前台展示
	 * @param request
	 * @param response
	 * @param model
	 * @param homeMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMenuList")
//	@ResponseBody
	public String queryMenuList(HttpServletRequest request, HttpServletResponse response,Model model,HomeMenuInfo homeMenuInfo) throws Exception {
		try {
			
			//设置最大展示数量
			homeMenuInfo.setPageNo(1);
			homeMenuInfo.setPageSize(1000);
			
			PageInfo<HomeMenuList> queryMenuList = iTHomeMenuSV.queryHomeMenuList(homeMenuInfo);
			if(queryMenuList != null && queryMenuList.getList() != null){
				model.addAttribute("list", queryMenuList.getList());
//				this.output(response, queryMenuList.getList());
			}else{
//				this.output(response, R.failure("没有菜单数据！"));
				throw new BusinessException("无菜单数据！");
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "stage/common/menu";
	}
	
	
	
	
}
