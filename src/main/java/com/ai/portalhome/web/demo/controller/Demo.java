package com.ai.portalhome.web.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/manager")
public class Demo {
	
	@RequestMapping(value = "/pageInit", method = RequestMethod.GET)
	public String pageInit(Model model) {
		
		System.out.println("111111111");
		return "manager/demo";
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Model model) {
		
		System.out.println("222222");
		return "index/index";
	}
	
	
	

}
