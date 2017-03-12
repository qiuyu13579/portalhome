package com.ai.portalhome.web.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 信息公开
 * @author Think
 *
 */
@Controller
@RequestMapping(value = "/xxgk")
public class XxgkController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	
	@RequestMapping(value = "/xxgk")
	public String xxgk(Model model) throws Exception {
		
		
		
		
		return "stage/xxgk/xxgk";
	}
	
	@RequestMapping(value = "/yxxgk")
	public String yxxgk(Model model) throws Exception {
		
		
		
		
		return "stage/xxgk/yxxgk";
	}
	
	
	@RequestMapping(value = "/sqjdcx")
	public String sqjdcx(Model model) throws Exception {
		
		
		
		
		return "stage/xxgk/sqjdcx";
	}
	
	@RequestMapping(value = "/zxsq")
	public String zxsq(Model model) throws Exception {
		
		
		
		
		return "stage/xxgk/zxsq";
	}
	
	/**
	 * 公开目录
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "gkml")
	public String gkml(Model model) throws Exception {
		
		
		
		
		return "stage/xxgk/gkml";
	}
	
	
}
