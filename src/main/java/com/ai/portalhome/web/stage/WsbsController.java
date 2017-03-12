package com.ai.portalhome.web.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/wsbs")
public class WsbsController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	
	@RequestMapping(value = "/bsdt")
	public String wsbs(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/bsdt";
	}
	
	/**
	 * 办事指南
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bszn")
	public String bszn(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/bszn";
	}
	/**
	 * 办事指南 - 某个指南
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/bsznNext")
	public String bsznNext(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/bsznNext";
	}
	
	
	@RequestMapping(value = "/bgxz")
	public String bgxz(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/bgxz";
	}
	
	
	/**
	 * 场景式服务
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cjsfw")
	public String cjsfw(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/cjsfw";
	}
	
	/**
	 * 场景式服务 - 下一级
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cjsfwNext")
	public String cjsfwNext(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/cjsfwNext";
	}
	
	/**
	 * 场景式服务 - 末级
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/cjsfwLast")
	public String cjsfwLast(Model model) throws Exception {
		
		
		
		
		return "stage/wsbs/cjsfwLast";
	}
	
	
}
