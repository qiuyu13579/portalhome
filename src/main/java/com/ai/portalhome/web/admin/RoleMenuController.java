package com.ai.portalhome.web.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.portalhome.common.utils.BeanUtil;
import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRole2Menu;
import com.ai.portalhome.service.interfaces.ITSysMenuSV;
import com.ai.portalhome.service.interfaces.ITSysRole2MenuSV;
import com.ai.portalhome.service.interfaces.ITSysRoleSV;
import com.ai.portalhome.vo.MenuInfo;
import com.ai.portalhome.vo.RoleInfo;
import com.ai.portalhome.vo.RoleMenuInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 角色管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/roleMenu")
public class RoleMenuController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITSysRole2MenuSV iTSysRole2MenuSV;
	@Autowired
	private ITSysRoleSV iTSysRoleSV;
	@Autowired
	private ITSysMenuSV iTSysMenuSV;
	
	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		
		Integer roleId = roleMenuInfo.getRoleId();
		if(roleId == null || roleId == 0){
			throw new BusinessException("角色编码为空");
		}
		TSysRole role = iTSysRoleSV.getRole(roleId);
		if(role != null){
			model.addAttribute("role", role);
		}
		
		return "admin/roleMenu/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		
		try {
			PageInfo<RoleMenuInfo> page = iTSysRole2MenuSV.getRoleMenuList(roleMenuInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/roleMenu/data";
	}
	
	/**
	 * 查询待选择的菜单列表
	 * @param request
	 * @param response
	 * @param model
	 * @param roleMenuInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataSel")
	public String getDataSel(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		try {
			
			//获取已选菜单
			Integer roleId = roleMenuInfo.getRoleId();
			List<Integer> menus = new ArrayList<Integer>();
			List<TSysRole2Menu> menuList = iTSysRole2MenuSV.getMenuList(roleMenuInfo);
			if(menuList != null && menuList.size() >= 1){
				for (int i = 0; i < menuList.size(); i++) {
					TSysRole2Menu role2Menu = menuList.get(i);
					menus.add(role2Menu.getMenuId());
				}
			}
			
			MenuInfo menuInfo = new MenuInfo();
			BeanUtil.copyVO(menuInfo, roleMenuInfo);
			menuInfo.setMenulist(menus);
			PageInfo<TSysMenu> pageInfo = iTSysMenuSV.getMenuList(menuInfo);
			
			model.addAttribute("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/roleMenu/dataSel";
	}
	
	
	/**
	 * 新增角色
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		try {
			TSysRole2Menu addRoleMenu = iTSysRole2MenuSV.addRoleMenu(roleMenuInfo);
			
			log.info("getRoleMenuId:"+addRoleMenu.getRoleId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新角色状态
	 * @param request
	 * @param response
	 * @param model
	 * @param roleMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		try {
			roleMenuInfo.setUpdateUser("testperson");
			TSysRole2Menu opRs = iTSysRole2MenuSV.udpateStatus(roleMenuInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询角色列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param roleMenuInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRoleList")
	@ResponseBody
	public void queryRoleList(HttpServletRequest request, HttpServletResponse response,Model model,RoleMenuInfo roleMenuInfo) throws Exception {
		try {
			
			//设置最大展示数量
			roleMenuInfo.setPageNo(1);
			roleMenuInfo.setPageSize(1000);
			
			PageInfo<TSysRole2Menu> queryRoleMenuList = iTSysRole2MenuSV.queryRoleMenuList(roleMenuInfo);
			if(queryRoleMenuList != null && queryRoleMenuList.getList() != null){
				this.output(response, queryRoleMenuList.getList());
			}else{
				this.output(response, R.failure("没有角色数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
}
