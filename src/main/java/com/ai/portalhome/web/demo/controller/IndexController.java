package com.ai.portalhome.web.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * index测试页面代码示例，参数传递推荐使用@PathVariable方式
 * @author yafei
 * @since 2016/10/12
 */
@Controller
@RequestMapping(value = "/demo")
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Logger log = LoggerFactory.getLogger(getClass().getName());
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        //获取参数方式
        //在方法中 使用@RequestParam 或者 @ModelAttribute 的方式

        //返回数据
        model.addAttribute("hello","index-hello");
        if (log.isDebugEnabled()) log.debug("hello的值为:" + "index-hello");

        //返回到根目录下index模板内容
        return "index";
    }

    @RequestMapping(value = "/testpage", method = RequestMethod.GET)
    public String testPage(Model model) {
        model.addAttribute("msg","hello, this is thymeleaf test page");
        if (log.isInfoEnabled()) log.info("这个是info日志："+"hello, this is test page");
        return "demo/testPage";
    }

    @RequestMapping(value = "/testpage2/{user}", method = RequestMethod.GET)
    public String testPage2(Model model, @PathVariable String user) {
        model.addAttribute("msg","hello "+user);
        return "demo/testPage";
    }

    @RequestMapping(value = "/thymetest", method = RequestMethod.GET)
    public String thymeTestPage(Model model) {
        model.addAttribute("msg","hello, this is thymeleaf test page");
        if (log.isInfoEnabled()) log.info("这个是info日志："+"hello, this is test page");
        return "tldemo/thymeTest";
    }
    
    @RequestMapping(value = "/imagetest", method = RequestMethod.GET)
    public String testImagePage(Model model) {

        return "tldemo/imageTest";
    }
    
}
