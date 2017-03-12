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

import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.service.interfaces.ITSysRoleSV;
import com.ai.portalhome.vo.RoleInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 角色管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/role")
public class RoleController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITSysRoleSV iTSysRoleSV;
	
	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		
		return "admin/role/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		
		try {
			PageInfo<TSysRole> page = iTSysRoleSV.getRoleList(roleInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/role/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param roleInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		
		try {
			PageInfo<TSysRole> page = iTSysRoleSV.getRoleList(roleInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/role/datahis";
	}
	
	
	
	
	/**
	 * 展示新增角色界面
	 * @param request
	 * @param response
	 * @param model
	 * @param roleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/role/add";
	}
	/**
	 * 新增角色
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			TSysRole addRole = iTSysRoleSV.addRole(roleInfo);
			
			log.info("getRoleId:"+addRole.getRoleId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看角色
	 * @param request
	 * @param response
	 * @param model
	 * @param roleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			
			Integer roleId = roleInfo.getRoleId();
			if(roleId == null || roleId == 0){
				throw new BusinessException("非法操作：无角色编码！");
			}
			
			TSysRole queryVO = iTSysRoleSV.getRole(roleId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/role/edit";
	}
	/**
	 * 编辑角色
	 * @param request
	 * @param response
	 * @param model
	 * @param roleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			TSysRole addRole = iTSysRoleSV.editRole(roleInfo);
			
			log.info("getRoleId:"+addRole.getRoleId());
			
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
	 * @param roleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			roleInfo.setUpdateUser("testperson");
			TSysRole opRs = iTSysRoleSV.udpateStatus(roleInfo);
			
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
	 * @param roleInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRoleList")
	@ResponseBody
	public void queryRoleList(HttpServletRequest request, HttpServletResponse response,Model model,RoleInfo roleInfo) throws Exception {
		try {
			
			//设置最大展示数量
			roleInfo.setPageNo(1);
			roleInfo.setPageSize(1000);
			
			PageInfo<TSysRole> queryRoleList = iTSysRoleSV.queryRoleList(roleInfo);
			if(queryRoleList != null && queryRoleList.getList() != null){
				this.output(response, queryRoleList.getList());
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
