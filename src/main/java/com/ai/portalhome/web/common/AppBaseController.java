package com.ai.portalhome.web.common;


import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.ai.paas.utils.StringUtil;
import com.ai.portalhome.common.utils.JsonUtil;

/**
 * BaseController
 * @author lixc
 */
public class AppBaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpSession session;
	@Autowired
	protected ServletContext servletContext;
	
	private Logger logger = Logger.getLogger(AppBaseController.class);
	
	public static final String CONTENTTYPE_HTML = "text/html";
	public static final String CONTENTTYPE_JSON = "application/json";
    public static final String CHARTSET_UTF8 = "utf-8";
    
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String getParam(String name){
    	return request.getParameter(name);
    }
    
    /**
     * 从Request获取参数
     * @param name
     * @return
     */
    final protected String[] getParams(String name){
    	return request.getParameterValues(name);
    }
    
    /**
     * 获取参数为Map
     * @return
     */
    @SuppressWarnings("unchecked")
	final protected Map<String,String> getParamMap(){
    	Map<String, String> m = new HashMap<String, String>();
        Iterator<String> keys = request.getParameterMap().keySet().iterator();
        while (keys.hasNext()) {
            String key = keys.next();
            m.put(key, getParam(key));
        }
        return m;
    }
    
    /**
     * 把request的参数转换成Object，要求客户端传递的是json格式{\"name\":\"val\"}
     * 如果字符串为空null\'',则返回null
     * @param name
     * @param c
     * @return
     */
    final protected <T> T json(String name, Class<T> c){
    	String jsonStr = getParam(name);
    	if(StringUtils.isBlank(jsonStr)){
    		return null;
    	}
    	else{
    		return JsonUtil.toObject(jsonStr, c);
    	}
    }
    
    /**
     * 把request的参数转换成List<Object>
     * 如果字符串为空null\''，则返回Collections.EMPTY_LIST
     * @param name
     * @param c
     * @return
     */
	final protected <T> List<T> jsons(String name, Class<T> c){
    	String jsonStr = getParam(name);
    	if(StringUtils.isBlank(jsonStr)){
    		return Collections.emptyList();
    	}
    	else{
    		return JsonUtil.toObjectList(jsonStr, c);
    	}
    }
	
    /**
     * 向HttpServletResponse输出文本
     * @param text 输出的字符串
     * @param contentType 类型
     * @param charset 编码
     */
    final public void outputText(HttpServletResponse response,String text, String contentType, String charset) {
    	response.setCharacterEncoding(charset);
        //指定内容类型
    	response.setContentType(contentType + ";charset=" + charset);
        //禁止缓存
    	response.setHeader("Pragma", "no-cache");
    	response.setHeader("Cache-Control", "no-cache");
    	response.setDateHeader("Expires", 0);
    	OutputStream o = null;
        try {
        	byte[] content = text.getBytes(charset);
        	o = response.getOutputStream();
        	o.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
        	try {
        		if(o!=null){
        			o.close();
        		}
        		o = null;
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }
    
    /**
     * 向客户端输出字符串，编码为UTF-8
     * @param text
     */
    final protected void outputString(HttpServletResponse response,String text){
    	logger.debug("输出Json : " + text);
    	this.outputText(response,text, CONTENTTYPE_JSON, CHARTSET_UTF8);
    }
    
    /**
     * 向客户端输出处理结果，格式为json
     * @param obj
     */
    final protected void output(HttpServletResponse response,Object obj){
    	//返回结果
        R rs = null;
        // 如果返回结果是Result
        if (obj instanceof R) {
            rs = (R) obj;
        }
        // 其它类型
        else {
            rs = R.success(obj);
        }
        
        String jsonString = JsonUtil.toJSONString(rs);
        this.outputString(response,jsonString);
    }
    
    final protected String getJsonCallback(Map<String, Object> map){
		String callback = getParam("callback");
		
		try{
			if(StringUtil.isBlank(callback)){
				return new ObjectMapper().writeValueAsString(map);
			}else{
				return callback+"("+new ObjectMapper().writeValueAsString(map)+")";
			}
		}catch (Exception e) {
            throw new RuntimeException("JsonUtil.toJSONString发生错误", e);
        }
	}
    
    /**
     * 向客户端返回结果
     */
    public static class R {
    	String msg;
        //是否处理成功
        boolean success;
        //数据
        Object data;
        //错误信息
        Map<String, String> errors;

        private R(){
        }
        
        /**
         * 成功，输入需要返回的结果
         * @param data 输出的结果
         * @return R
         */
        public static R success(Object data){
            R rs = new R();
            rs.success = true;
            rs.data = data;
            rs.errors = null;
            return rs;
        }
        
        /**
         * 失败，输入一系列错误消息，如果参数只有1个则在errors中增加一个叫message的消息
         * 如果是多个参数则按消息名，消息内容；消息名，消息内容增加到errors
         * @param msg
         * @return
         */
        public static R failure(String ... msg){
            R rs = new R();
            rs.success = false;
            rs.data = null;
            rs.errors = new HashMap<String, String>();
            if(msg.length==1){
                rs.errors.put("message", msg[0]);
            }
            else{
                for(int i=1; i<msg.length; i+=2){
                    rs.errors.put(String.valueOf(msg[i-1]), msg[i]);
                }
            }
            return rs;
        }
        
        /**
         * 失败，输入错误消息的Map
         * @param errors
         * @return
         */
        public static R failure(Map<String, String> errors){
        	R rs = new R();
            rs.success = false;
            rs.data = null;
            rs.errors = errors;
            return rs;
        }
        
        public static R failure(String msg){
        	R rs = new R();
        	rs.success = false;
        	rs.msg = msg;
//        	rs.errors = errors;
        	return rs;
        }

        public boolean isSuccess() {
            return success;
        }
        
        public void setData(Object data){
        	this.data = data;
        }

        public Object getData() {
            return data;
        }

        public Map<String, String> getErrors() {
            return errors;
        }

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}
        
        
    }

}
