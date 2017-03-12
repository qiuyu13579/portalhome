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

import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.service.interfaces.ITSysMenuSV;
import com.ai.portalhome.vo.MenuInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 菜单管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITSysMenuSV iTSysMenuSV;
	
	/**
	 * 菜单管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		
		try {
//			PageInfo<TSysMenu> page = iTSysMenuSV.getMenuList(menuInfo);
			
//			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/menu/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		
		try {
			PageInfo<TSysMenu> page = iTSysMenuSV.getMenuList(menuInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/menu/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param menuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		
		try {
			PageInfo<TSysMenu> page = iTSysMenuSV.getMenuList(menuInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/menu/datahis";
	}
	
	
	
	
	/**
	 * 展示新增菜单界面
	 * @param request
	 * @param response
	 * @param model
	 * @param menuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/menu/add";
	}
	/**
	 * 新增菜单
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			TSysMenu addMenu = iTSysMenuSV.addMenu(menuInfo);
			
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
	 * @param menuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			
			Integer menuId = menuInfo.getMenuId();
			if(menuId == null || menuId == 0){
				throw new BusinessException("非法操作：无菜单编码！");
			}
			
			TSysMenu queryVO = iTSysMenuSV.getMenu(menuId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/menu/edit";
	}
	/**
	 * 编辑菜单
	 * @param request
	 * @param response
	 * @param model
	 * @param menuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			TSysMenu addMenu = iTSysMenuSV.editMenu(menuInfo);
			
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
	 * @param menuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			menuInfo.setUpdateUser("testperson");
			TSysMenu opRs = iTSysMenuSV.udpateStatus(menuInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询菜单列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param menuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMenuList")
	@ResponseBody
	public void queryMenuList(HttpServletRequest request, HttpServletResponse response,Model model,MenuInfo menuInfo) throws Exception {
		try {
			
			//设置最大展示数量
			menuInfo.setPageNo(1);
			menuInfo.setPageSize(1000);
			
			PageInfo<TSysMenu> queryMenuList = iTSysMenuSV.queryMenuList(menuInfo);
			if(queryMenuList != null && queryMenuList.getList() != null){
				this.output(response, queryMenuList.getList());
			}else{
				this.output(response, R.failure("没有菜单数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
	
	
}
