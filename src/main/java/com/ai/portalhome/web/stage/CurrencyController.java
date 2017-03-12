package com.ai.portalhome.web.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/currency")
public class CurrencyController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	/**
	 * 通用界面 - 一级
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/first")
	public String wzdt(Model model) throws Exception {
		
		
		
		
		return "stage/currency/first";
	}
	
	/**
	 * 通用界面 - 二级
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/second")
	public String second(Model model) throws Exception {
		
		
		
		
		return "stage/currency/second";
	}
	
	
}
