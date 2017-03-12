package com.ai.portalhome.web.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/admin")
public class IndexMgController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String init(Model model) throws Exception {
		
		
		
		
		return "admin/index";
	}
	
	@RequestMapping(value = "/myfirst", method = RequestMethod.GET)
	public String myfirst(Model model) throws Exception {
		
		
		
		
		return "admin/default";
	}
	
}
