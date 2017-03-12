package com.ai.portalhome.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.portalhome.dao.model.TArticleGroup;
import com.ai.portalhome.service.interfaces.ITArticleGroupSV;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 文章分组管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/articleGroup")
public class ArticleGroupController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITArticleGroupSV iTArticleGroupSV;
//	@Autowired
//	private ITArticleGroupSV iTArticleGroupSV;
	
	/**
	 * 文章分组管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		
//		Integer olId = articleGroupInfo.getOlId();
//		if(olId != null && olId != 0){
//			model.addAttribute("olId", olId);
//		}
		return "admin/articleGroup/manager";
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
			PageInfo<TArticleGroup> page = iTArticleGroupSV.getList(articleGroupInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/articleGroup/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		
		try {
			PageInfo<TArticleGroup> page = iTArticleGroupSV.getList(articleGroupInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/articleGroup/datahis";
	}
	
	
	
	
	/**
	 * 展示新增文章分组界面
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/articleGroup/add";
	}
	/**
	 * 新增栏目
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			TArticleGroup add = iTArticleGroupSV.add(articleGroupInfo);
			
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
	 * @param articleGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			
			Integer id = articleGroupInfo.getGroupId();
			if(id == null || id == 0){
				throw new BusinessException("非法操作：无栏目编码！");
			}
			
			TArticleGroup queryVO = iTArticleGroupSV.get(id);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/articleGroup/edit";
	}
	/**
	 * 编辑栏目
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			TArticleGroup add = iTArticleGroupSV.edit(articleGroupInfo);
			
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
	 * @param articleGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
		try {
			articleGroupInfo.setUpdateUser("testperson");
			TArticleGroup opRs = iTArticleGroupSV.udpateStatus(articleGroupInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询栏目列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param articleGroupInfo
	 * @throws Exception
	 */
//	@RequestMapping(value = "/queryList")
//	public void queryList(HttpServletRequest request, HttpServletResponse response,Model model,ArticleGroupInfo articleGroupInfo) throws Exception {
//		try {
//			
//			//设置最大展示数量
//			articleGroupInfo.setPageNo(1);
//			articleGroupInfo.setPageSize(1000);
//			
//			PageInfo<TArticleGroup> queryList = iTArticleGroupSV.queryList(articleGroupInfo);
//			if(queryList != null && queryList.getList() != null){
//				this.output(response, queryList.getList());
//			}else{
//				this.output(response, R.failure("没有栏目数据！"));
//			}
//		} catch (Exception e) {
//			this.output(response, R.failure(e.getMessage()));
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//	}
	
	
	
	
}
