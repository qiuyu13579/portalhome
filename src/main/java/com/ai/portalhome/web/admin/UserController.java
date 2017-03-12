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

import com.ai.portalhome.dao.model.TUserInfo;
import com.ai.portalhome.service.interfaces.ITUserInfoSV;
import com.ai.portalhome.vo.UserInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 用户管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITUserInfoSV iTUserInfoSV;
	
	/**
	 * 用户管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		
		try {
//			PageInfo<TUserInfo> page = iTUserInfoSV.getUserList(userInfo);
			
//			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/user/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		
		try {
			PageInfo<TUserInfo> page = iTUserInfoSV.getUserList(userInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/user/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		
		try {
			PageInfo<TUserInfo> page = iTUserInfoSV.getUserList(userInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/user/datahis";
	}
	
	
	
	
	/**
	 * 展示新增用户界面
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/user/add";
	}
	/**
	 * 新增用户
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			
			userInfo.setCreateUser("testperson");
			
			TUserInfo addUser = iTUserInfoSV.addUser(userInfo);
			
//			log.info("getUserId:"+addUser.getUserId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看用户
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			
			Integer userId = userInfo.getUserId();
			if(userId == null || userId == 0){
				throw new BusinessException("非法操作：无用户编码！");
			}
			
			TUserInfo queryVO = iTUserInfoSV.getUser(userId);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/user/edit";
	}
	/**
	 * 编辑用户
	 * @param request
	 * @param response
	 * @param model
	 * @param UserInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			
			userInfo.setUpdateUser("testperson");
			
			TUserInfo addUser = iTUserInfoSV.editUser(userInfo);
			
//			log.info("getUserId:"+addUser.getUserId());
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新用户状态
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			userInfo.setUpdateUser("testperson");
			TUserInfo opRs = iTUserInfoSV.udpateStatus(userInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询用户列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param userInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryUserList")
	@ResponseBody
	public void queryUserList(HttpServletRequest request, HttpServletResponse response,Model model,UserInfo userInfo) throws Exception {
		try {
			
			//设置最大展示数量
			userInfo.setPageNo(1);
			userInfo.setPageSize(1000);
			
			PageInfo<TUserInfo> queryUserList = iTUserInfoSV.queryUserList(userInfo);
			if(queryUserList != null && queryUserList.getList() != null){
				this.output(response, queryUserList.getList());
			}else{
				this.output(response, R.failure("没有用户数据！"));
			}
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
	
	
}
