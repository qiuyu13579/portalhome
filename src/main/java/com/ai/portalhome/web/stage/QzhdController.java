package com.ai.portalhome.web.stage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/qzhd")
public class QzhdController {

	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	 
	
	
	/**
	 * 领导邮箱
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/ldyx")
	public String ldyx(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/ldyx";
	}
	
	
	/**
	 * 在线解答
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxjd")
	public String zxjd(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxjd";
	}
	/**
	 * 在线解答 - 查看单个解答
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxjdOne")
	public String zxjdOne(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxjdOne";
	}
	/**
	 * 在线解答 - 提交问题
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxjdFormAdd")
	public String zxjdFormAdd(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxjdFormAdd";
	}
	
	/**
	 * 意见征集
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yjzj")
	public String yjzj(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/yjzj";
	}
	/**
	 * 意见征集 - 查看单个意见
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yjzjOne")
	public String yjzjOne(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/yjzjOne";
	}
	/**
	 * 意见征集 - 提交表单
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/yjzjFormAdd")
	public String yjzjFormAdd(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/yjzjFormAdd";
	}
	
	/**
	 * 网上信访
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/wsxf")
	public String wsxf(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/wsxf";
	}
	
	/**
	 * 在线访谈 - 主页
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxft")
	public String zxft(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxft";
	}
	
	/**
	 * 在线访谈 - 单个访谈内容
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxftOne")
	public String zxftOne(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxftOne";
	}
	
	/**
	 * 在线访谈 - 参与访谈
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/zxftOnLine")
	public String zxftOnLine(Model model) throws Exception {
		
		
		
		
		return "stage/qzhd/zxftOnLine";
	}
	
	
	
	
}
