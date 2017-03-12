//package com.ai.portalhome.config;
//
//import org.springframework.boot.context.embedded.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.ai.portalhome.system.filter.LoginFilter;
//
//@Configuration
//public class WebConfig {
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(LoginFilter loginFilter){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(loginFilter);
//        filterRegistrationBean.setEnabled(true);
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//}