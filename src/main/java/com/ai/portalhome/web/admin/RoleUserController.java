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
import com.ai.portalhome.dao.model.TUserInfo;
import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRole2User;
import com.ai.portalhome.dao.model.TUserInfo;
import com.ai.portalhome.service.interfaces.ITUserInfoSV;
import com.ai.portalhome.service.interfaces.ITSysRole2UserSV;
import com.ai.portalhome.service.interfaces.ITSysRoleSV;
import com.ai.portalhome.service.interfaces.ITUserInfoSV;
import com.ai.portalhome.vo.UserInfo;
import com.ai.portalhome.vo.RoleInfo;
import com.ai.portalhome.vo.RoleUserInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 角色管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/roleUser")
public class RoleUserController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITSysRole2UserSV iTSysRole2UserSV;
	@Autowired
	private ITSysRoleSV iTSysRoleSV;
	@Autowired
	private ITUserInfoSV iTUserInfoSV;
	
	/**
	 * 角色管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		
		Integer userId = roleUserInfo.getUserId();
		if(userId == null || userId == 0){
			throw new BusinessException("用户编码为空");
		}
		TUserInfo user = iTUserInfoSV.getUser(userId);
		if(user != null){
			model.addAttribute("user", user);
		}
		
		return "admin/roleUser/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		
		try {
			PageInfo<RoleUserInfo> page = iTSysRole2UserSV.getRoleUserList(roleUserInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/roleUser/data";
	}
	
	/**
	 * 查询待选择的角色列表
	 * @param request
	 * @param response
	 * @param model
	 * @param roleUserInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataSel")
	public String getDataSel(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		try {
			
			//获取已选角色
			List<Integer> roles = new ArrayList<Integer>();
			List<TSysRole2User> role2UserList = iTSysRole2UserSV.getRoleList(roleUserInfo);
			if(role2UserList != null && role2UserList.size() >= 1){
				for (int i = 0; i < role2UserList.size(); i++) {
					TSysRole2User role2User = role2UserList.get(i);
					roles.add(role2User.getRoleId());
				}
			}
			
			RoleInfo roleInfo = new RoleInfo();
			BeanUtil.copyVO(roleInfo, roleUserInfo);
			roleInfo.setRoleList(roles);
			PageInfo<TSysRole> pageInfo = iTSysRoleSV.getRoleList(roleInfo);
			
			model.addAttribute("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/roleUser/dataSel";
	}
	
	
	/**
	 * 新增角色
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		try {
			TSysRole2User addRoleUser = iTSysRole2UserSV.addRoleUser(roleUserInfo);
			
			log.info("getRoleUserId:"+addRoleUser.getRoleId());
			
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
	 * @param roleUserInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		try {
			roleUserInfo.setUpdateUser("testperson");
			TSysRole2User opRs = iTSysRole2UserSV.udpateStatus(roleUserInfo);
			
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
	 * @param roleUserInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryRoleList")
	@ResponseBody
	public void queryRoleList(HttpServletRequest request, HttpServletResponse response,Model model,RoleUserInfo roleUserInfo) throws Exception {
		try {
			
			//设置最大展示数量
			roleUserInfo.setPageNo(1);
			roleUserInfo.setPageSize(1000);
			
			PageInfo<TSysRole2User> queryRoleUserList = iTSysRole2UserSV.queryRoleUserList(roleUserInfo);
			if(queryRoleUserList != null && queryRoleUserList.getList() != null){
				this.output(response, queryRoleUserList.getList());
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
