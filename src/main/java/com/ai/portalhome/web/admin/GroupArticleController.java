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
import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.dao.model.TArticleGroup2Car;
import com.ai.portalhome.dao.model.TArticleInfo;
import com.ai.portalhome.dao.model.TSysMenu;
import com.ai.portalhome.dao.model.TSysRole;
import com.ai.portalhome.dao.model.TSysRole2Menu;
import com.ai.portalhome.service.interfaces.ITArticleGroupSV;
import com.ai.portalhome.service.interfaces.ITArticleInfoSV;
import com.ai.portalhome.service.interfaces.ITGroup2ArticleSV;
import com.ai.portalhome.service.interfaces.ITSysMenuSV;
import com.ai.portalhome.service.interfaces.ITSysRole2MenuSV;
import com.ai.portalhome.service.interfaces.ITSysRoleSV;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ai.portalhome.vo.ArticleInfo;
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
@RequestMapping(value = "/groupArticle")
public class GroupArticleController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITArticleGroupSV iTArticleGroupSV;
	@Autowired
	private ITGroup2ArticleSV iTGroup2ArticleSV;
	@Autowired
	private ITArticleInfoSV iTArticleInfoSV;
	
	/**
	 * 管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		
		Integer groupId = articleGroupInfo.getGroupId();
		if(groupId == null || groupId == 0){
			throw new BusinessException("分组编码为空");
		}
		TArticleGroup info = iTArticleGroupSV.get(groupId);
		if(info != null){
			model.addAttribute("info", info);
		}
		
		return "admin/groupArticle/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		
		try {
			PageInfo<ArticleGroupInfo> page = iTGroup2ArticleSV.getList(articleGroupInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/groupArticle/data";
	}
	
	/**
	 * 查询待选择的菜单列表
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataSel")
	public String getDataSel(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			
			//获取已选菜单
			Integer groupId = articleGroupInfo.getGroupId();
			List<Integer> ids = new ArrayList<Integer>();
			List<TArticleGroup2Car> list = iTGroup2ArticleSV.getAllList(articleGroupInfo);
			if(list != null && list.size() >= 1){
				for (int i = 0; i < list.size(); i++) {
					TArticleGroup2Car vo = list.get(i);
					ids.add(vo.getArtId());
				}
			}
			ArticleInfo info = new ArticleInfo();
			BeanUtil.copyVO(info, articleGroupInfo);
			info.setIds(ids);
			PageInfo<TArticleInfo> pageInfo = iTArticleInfoSV.getList(info);
			
			model.addAttribute("pageInfo", pageInfo);
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/groupArticle/dataSel";
	}
	
	
	/**
	 * 新增角色
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			TArticleGroup2Car addRoleMenu = iTGroup2ArticleSV.add(articleGroupInfo);
			
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
	 * @param articleGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			articleGroupInfo.setUpdateUser("testperson");
			TArticleGroup2Car opRs = iTGroup2ArticleSV.udpateStatus(articleGroupInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
}
