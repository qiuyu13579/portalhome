package com.ai.portalhome.web.stage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ai.portalhome.common.constants.Constant;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	/**
	 * 首页
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String init(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		
		
		
		model.addAttribute("olId", Constant.HOME_CUSTOM_COL_ID);//设置布局编码
		model.addAttribute("modelId", Constant.HOME_CUSTOM_MODEL_ID);//设置模块
		
		return "stage/home/index";
	}
	/**
	 * 首页-测试
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/test")
	public String test(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {
		
		
		
		model.addAttribute("olId", Constant.HOME_CUSTOM_COL_ID);//设置布局编码
		
		return "stage/home/customTest";
	}
	
	@RequestMapping(value = "/main")
	public String myfirst(Model model) throws Exception {
		
		
		
		
		return "stage/home/main";
	}
	
	
	/**
	 * 搜索
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/sousuo")
	public String sousuo(Model model) throws Exception {
		
		
		
		
		return "stage/home/sousuo";
	}
	
	/**
	 * 网站地图
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/wzdt")
	public String wzdt(Model model) throws Exception {
		
		
		
		
		return "stage/home/wzdt";
	}
	
	/**
	 * 子处室
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zcsIndex")
	public String zcsIndex(Model model) throws Exception {
		
		
		
		
		return "stage/home/zcsIndex";
	}
	
	
}
