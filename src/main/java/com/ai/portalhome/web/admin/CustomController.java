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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.paas.util.ImageUtil;
import com.ai.portalhome.common.constants.Constant;
import com.ai.portalhome.dao.model.TLoColumn;
import com.ai.portalhome.dao.model.TLoColumnData;
import com.ai.portalhome.service.interfaces.ITArticleGroupSV;
import com.ai.portalhome.service.interfaces.ITCarouselSV;
import com.ai.portalhome.service.interfaces.ITCellGroupSV;
import com.ai.portalhome.service.interfaces.ITLoMainSV;
import com.ai.portalhome.vo.ArticleGroupInfo;
import com.ai.portalhome.vo.CarouselInfo;
import com.ai.portalhome.vo.CellGroupInfo;
import com.ai.portalhome.vo.CellGroupList;
import com.ai.portalhome.vo.CustomInfo;
import com.ai.portalhome.vo.GroupArticleList;
import com.ai.portalhome.vo.LoMainInfo;
import com.ai.portalhome.web.common.AppBaseController;
import com.ailk.aip.provider.exception.BusinessException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 自定义布局
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/custom")
public class CustomController extends AppBaseController{

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	
	@Autowired
	private ITLoMainSV iTLoMainSV;
	@Autowired
	private ITCarouselSV iTCarouselInfoSV; 
	@Autowired
	private ITArticleGroupSV iTArticleGroupSV;
	@Autowired
	private ITCellGroupSV iTCellGroupSV;
	
	/**
	 * 管理
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/manager", method = RequestMethod.GET)
	public String init(Model model) throws Exception {
		
		
		
		
		return "admin/custom/manager";
	}
	
	
	/**
	 * 编辑模块布局
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/editModelLo", method = RequestMethod.GET)
	public String editModelLo(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		Integer olId = loMainInfo.getOlId();
		if(olId != null && olId != 0){
			model.addAttribute("olId", olId);
		}
		return "admin/custom/main";
	}
	
	
	
	/**
	 * 编辑模块布局
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ajaxLoColumns")
	@ResponseBody
	public void ajaxLoColumns(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		Integer olId = loMainInfo.getOlId();
		if(olId == null || olId == 0){
			throw new BusinessException("模块编码为空");
		}
		try {
			LoMainInfo lo = iTLoMainSV.getLo(olId);
			if(lo != null){
				this.output(response, lo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	
	@RequestMapping(value = "/editLoColumn")
	@ResponseBody
	public void editLoColumn(HttpServletRequest request, HttpServletResponse response,Model model,LoMainInfo loMainInfo) throws Exception {
		
		Integer olId = loMainInfo.getOlId();
		if(olId == null || olId == 0){
			throw new BusinessException("模块编码为空");
		}
		
		String list_str = this.getParam("list");
		JSONArray listJSON = JSONArray.fromObject(list_str);
		
		
		if (listJSON != null && listJSON.size() > 0) {
			List<TLoColumn> listColumn = new ArrayList<TLoColumn>();
			for (int i = 0; i < listJSON.size(); i++) {
				JSONObject object = (JSONObject) listJSON.get(i);
				String x = object.getString("x");
				String y = object.getString("y");
				String width = object.getString("width");
				String height = object.getString("height");
				String colId = object.getString("colId");
				
				TLoColumn column = new TLoColumn();
				column.setColX(Integer.valueOf(x));
				column.setColY(Integer.valueOf(y));
				column.setColWidth(Integer.valueOf(width));
				column.setColHeigh(Integer.valueOf(height));
				column.setColId(Integer.valueOf(colId));
				
				listColumn.add(column);
			}
			loMainInfo.setListColumn(listColumn);
		}else{
			throw new BusinessException("保存的数据为空");
		}
		
		try {
			
			//设置修改人
			loMainInfo.setUpdateUser("testperson");
			
			LoMainInfo lo = iTLoMainSV.editLoColumn(loMainInfo);
			if(lo != null){
				this.output(response, lo);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}
	
	/**
	 * 获取不同栏目对应的内容
	 * @param request
	 * @param response
	 * @param model
	 * @param customInfo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getColHTML")
	public String getColHTML(HttpServletRequest request, HttpServletResponse response,Model model,CustomInfo customInfo) throws Exception {
		
		Integer colId = customInfo.getColId();
		if(colId == null || colId == 0){
			throw new BusinessException("栏目编号为空!");
		}
		
		String rsPath = "stage/home/custom/";
		String colType = "";
		
		CustomInfo column_ = iTLoMainSV.getColumn(customInfo);
		TLoColumn column = column_.getColumn();
		TLoColumnData columnData = column_.getColumnData();
		
		if(column != null && columnData != null){
			
//			Integer colX = column.getColX();
//			Integer colY = column.getColY();
//			Integer colWidth = column.getColWidth();
//			Integer colHeigh = column.getColHeigh();
			
			
			colType = column.getColType();
			
			
			
			
			//根据不同类型处理不同数据
			if(colType.equals(Constant.CUSTOM_COL_TYPE_CAR)){//轮播
				
				Integer carId = 0;
				
				if(columnData != null && columnData.getCarId() != null && columnData.getCarId() != 0){
					carId = columnData.getCarId();
				}else{
					throw new BusinessException("轮播加载异常! colId="+colId);
				}
				
				CarouselInfo carouseInfo = new CarouselInfo();
				
				//设置最大展示数量
				carouseInfo.setPageNo(1);
				carouseInfo.setPageSize(1000);
				carouseInfo.setCarId(carId);
				
				CarouselInfo car = iTCarouselInfoSV.queryCarouselList(carouseInfo);
				if(car != null && car.getDataList() != null){
					model.addAttribute("car", car);
					model.addAttribute("list", car.getDataList());
				}else{
					throw new BusinessException("轮播加载异常! carId="+carId);
				}
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_IMAGE)){//图片
				
				String imageUrl = "";
				if(columnData != null && columnData.getImageUrl() != null
						&& !"".equals(columnData.getImageUrl())){
					imageUrl = columnData.getImageUrl();
					model.addAttribute("imageUrl", ImageUtil.getImageUrl(imageUrl));
					model.addAttribute("column",column_);
					model.addAttribute("columnData",columnData);
				}else{
					throw new BusinessException("轮播加载异常! colId="+colId);
				}
				
				
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_ART)){//文章
				
				
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_AG)){//文章列表
				
				String agId = columnData.getAgId();
				if(agId != null && agId.split(",") !=null && agId.split(",").length >= 1){
					String[] strings = agId.split(",");
					List<Integer> ids = new ArrayList<Integer>();
					for (int i = 0; i < strings.length; i++) {
						String str = strings[i];
						if(!"".equals(str)){
							ids.add(Integer.valueOf(str));
						}
					}
					ArticleGroupInfo articleGroupInfo = new ArticleGroupInfo();
					articleGroupInfo.setIds(ids);
					
					List<GroupArticleList> showList = iTArticleGroupSV.getShowList(articleGroupInfo);
					if(showList != null && showList.size() >= 1){
						model.addAttribute("list",showList);
					}else{
						throw new BusinessException("文章分组列表加载异常! colId="+colId);
					}
					
				}else{
					throw new BusinessException("文章分组列表加载异常! colId="+colId);
				}
				
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_UN)){//单元格列表
				
				Integer unId = columnData.getUnId();
				if(unId != null && unId != 0){
					
					CellGroupInfo cellGroupInfo = new CellGroupInfo();
					cellGroupInfo.setGroupId(unId);
					CellGroupList showList = iTCellGroupSV.getShowList(cellGroupInfo);
					if(showList != null){
						model.addAttribute("info",showList);
					}else{
						throw new BusinessException("单元格分组列表加载异常! colId="+colId);
					}
				}else{
					throw new BusinessException("单元格分组列表加载异常! colId="+colId);
				}
				
				
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_TG)){//文本分组
				
				
			}else if(colType.equals(Constant.CUSTOM_COL_TYPE_ADRESS)){//指定URL
				
				
			}else {
				throw new BusinessException("栏目类型异常!");
			}
			
		}else{
			throw new BusinessException("获取不到栏目信息!");
		}
		
		return rsPath+colType;
	}
	
}
