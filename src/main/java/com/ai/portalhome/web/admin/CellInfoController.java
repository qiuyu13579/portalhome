package com.ai.portalhome.web.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.portalhome.dao.model.TCellGroup;
import com.ai.portalhome.dao.model.TCellInfo;
import com.ai.portalhome.service.interfaces.ITCellGroupSV;
import com.ai.portalhome.service.interfaces.ITCellInfoSV;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;
import com.github.pagehelper.PageInfo;

/**
 * 文章分组管理
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/cellInfo")
public class CellInfoController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	@Autowired
	private ITCellInfoSV iTCellInfoSV;
	@Autowired
	private ITCellGroupSV tTCellGroupSV;
	
	/**
	 * 文章分组管理
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager")
	public String manager(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		
		Integer groupId = cellGroupInfo.getGroupId();
		if(groupId != null && groupId != 0){
			model.addAttribute("groupId", groupId);
			TCellGroup group = tTCellGroupSV.get(groupId);
			if(group != null){
				model.addAttribute("group", group);
			}
		}else{
			throw new BusinessException("缺少分组编码！");
		}
		return "admin/cellInfo/manager";
	}
	
	/**
	 * 获取展示数据列表
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getData")
	public String getData(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		
		try {
			PageInfo<TCellInfo> page = iTCellInfoSV.getList(cellGroupInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/cellInfo/data";
	}
	
	/**
	 * 获取展示数据列表 - 历史
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getDataHis")
	public String getDataHis(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		
		try {
			PageInfo<TCellInfo> page = iTCellInfoSV.getList(cellGroupInfo);
			
			model.addAttribute("pageInfo", page );
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return "admin/cellInfo/datahis";
	}
	
	
	
	
	/**
	 * 展示新增文章分组界面
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/showAdd")
	public String showAdd(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/cellInfo/add";
	}
	/**
	 * 新增分组
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public void add(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		try {
			TCellInfo add = iTCellInfoSV.add(cellGroupInfo);
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	/**
	 * 查看分组
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/select")
	public String select(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		try {
			
			Integer id = cellGroupInfo.getCelId();
			if(id == null || id == 0){
				throw new BusinessException("非法操作：无分组编码！");
			}
			
			TCellInfo queryVO = iTCellInfoSV.get(id);
			if(queryVO != null){
				model.addAttribute("info", queryVO );
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
		return "admin/cellInfo/edit";
	}
	/**
	 * 编辑分组
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public void edit(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		try {
			TCellInfo add = iTCellInfoSV.edit(cellGroupInfo);
			
			this.output(response, "");
			
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 更新分组状态
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateStatus")
	public void updateStatus(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
		try {
			cellGroupInfo.setUpdateUser("testperson");
			TCellInfo opRs = iTCellInfoSV.udpateStatus(cellGroupInfo);
			
			this.output(response, "");
		} catch (Exception e) {
			this.output(response, R.failure(e.getMessage()));
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 查询分组列表 - 后台管理展示
	 * @param request
	 * @param response
	 * @param model
	 * @param cellGroupInfo
	 * @throws Exception
	 */
//	@RequestMapping(value = "/queryList")
//	public void queryList(HttpServletRequest request, HttpServletResponse response,Model model,CellGroupInfo cellGroupInfo) throws Exception {
//		try {
//			
//			//设置最大展示数量
//			cellGroupInfo.setPageNo(1);
//			cellGroupInfo.setPageSize(1000);
//			
//			PageInfo<TCellInfo> queryList = iTCellInfoSV.queryList(cellGroupInfo);
//			if(queryList != null && queryList.getList() != null){
//				this.output(response, queryList.getList());
//			}else{
//				this.output(response, R.failure("没有分组数据！"));
//			}
//		} catch (Exception e) {
//			this.output(response, R.failure(e.getMessage()));
//			e.printStackTrace();
//			log.error(e.getMessage());
//		}
//	}
	
	
	
	
}
