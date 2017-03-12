package com.ai.portalhome.web.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/other")
public class OtherController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	/**
	 * 网站地图
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/wzdt")
	public String wzdt(Model model) throws Exception {
		
		
		
		
		return "stage/other/wzdt";
	}
	
	/**
	 * 领导邮箱
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ldyx")
	public String ldyx(Model model) throws Exception {
		
		
		
		
		return "stage/other/ldyx";
	}
	
	
}
