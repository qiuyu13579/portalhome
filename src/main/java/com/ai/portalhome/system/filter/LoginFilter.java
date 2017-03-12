package com.ai.portalhome.system.filter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ai.woego.front.vo.busi.login.StaffInfoVO;



@Component("loginFilter")  
public class LoginFilter implements Filter{
	
	private String loginPage = "/login/pageInit";
	
	private static Logger logger = LoggerFactory.getLogger(LoginFilter.class);

	public static String[] IGNORE_SUFFIX={};
	
	private static String[] IGNORE_PAGES = {};


	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	private  boolean isLogin(HttpSession session) {
		if(session==null){
			return false;
		}
		Object obj = session.getAttribute("staffInfoVO");
		if(obj == null){
			return false;
		}
		StaffInfoVO staffInfoVO=(StaffInfoVO)obj;
		if(staffInfoVO.isLoginIn()){
			System.out.println("登录成功:"+staffInfoVO.toString());
			return true;	
		}else{
			return false;
		}
		
		
	}
	
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		logger.info("过滤器开始");
		//chain.doFilter(request, response);
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		//未登陆，重定向到登录页面
/*		if( !isLogin(session))
		{
			//String redirectUrl = this.loginPage+"?toUrl="+toChnlUrl(request);
			String redirectUrl = "chnldev.woego.cn:19413/woego"+loginPage;
			response.sendRedirect(request.getScheme()+"://"+redirectUrl);
			return;
		}*/

		filterChain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
	protected ArrayList<String> getWoegoRequestedSessionId(HttpServletRequestWrapper request) {
		Cookie[] cookies = request.getCookies();
		ArrayList<String> sessionIds = new ArrayList<String>();
		if(cookies != null && cookies.length != 0) {
			for(Cookie cookie : cookies) {
				if("WOEGO_JSESSIONID".equals(cookie.getName())) {
					sessionIds.add(cookie.getValue());
				}
			}
			return sessionIds;
		} else {
			return null;
		}
	}
    
}
