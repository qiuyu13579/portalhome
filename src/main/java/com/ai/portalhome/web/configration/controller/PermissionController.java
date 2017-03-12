package com.ai.portalhome.web.configration.controller;

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
@RequestMapping(value = "/permission")
public class PermissionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final Logger log = LoggerFactory.getLogger(getClass().getName());
    @RequestMapping(value = "/pageInit", method = RequestMethod.GET)
    public String pageInit(Model model) {
        //获取参数方式
        //在方法中 使用@RequestParam 或者 @ModelAttribute 的方式

        //返回数据
 /*       model.addAttribute("hello","index-hello");
        if (log.isDebugEnabled()) log.debug("hello的值为:" + "index-hello");
*/
        //返回到根目录下configurationTable模板内容
        return "configuration/configurationTable";
    }

    @RequestMapping(value = "/getPermission", method = RequestMethod.GET)
    public String getOrganizationTree(Model model) {
//        model.addAttribute("msg","hello, this is testpage");
//        if (log.isInfoEnabled()) log.info("这个是info日志："+"hello, this is testpage");
        return "configuration/div/permissionConfig";
    }

 
}
