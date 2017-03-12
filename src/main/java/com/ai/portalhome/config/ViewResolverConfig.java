//package com.ai.portalhome.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigureAfter;
//import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
//import org.springframework.boot.autoconfigure.velocity.VelocityProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;
//
///**
// * Velocity视图模板配置类，覆盖spring-boot-starter-velocity中的布局layout配置，使用layout模板简化布局
// * 该配置在VelocityAutoConfiguration生效后执行
// * Spring官方已经放弃velocity的支持了，要不要引入新的前端模板框架？貌似thymeleaf很流行。
// * @author yafei
// * @since 2016/10/13
// */
//@Configuration
//@AutoConfigureAfter(VelocityAutoConfiguration.class)
//public class ViewResolverConfig extends VelocityAutoConfiguration {
//
//    @SuppressWarnings("SpringJavaAutowiringInspection")
//    @Autowired
//    protected VelocityProperties properties;
//
//    /**
//     * 生成velocityViewResolver对象，类型是VelocityLayoutViewResolver以支持模板布局功能，
//     * 使用/layout/layout.vm作为视图模板。
//     */
//    @Bean(name = "velocityViewResolver")
//    VelocityLayoutViewResolver velocityLayoutViewResolver() {
//        VelocityLayoutViewResolver viewResolver = new VelocityLayoutViewResolver();
//        properties.applyToViewResolver(viewResolver);
//        viewResolver.setScreenContentKey("screen_content");
//        viewResolver.setLayoutUrl("/layout/layout.vm");
//        return viewResolver;
//    }
//}
