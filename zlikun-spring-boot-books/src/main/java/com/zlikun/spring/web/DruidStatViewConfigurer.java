package com.zlikun.spring.web;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 16:11
 */
@Configuration
public class DruidStatViewConfigurer {

    @Bean
    public ServletRegistrationBean druidStatViewServlet() {
        ServletRegistrationBean srb = new ServletRegistrationBean() ;
        srb.setServlet(new StatViewServlet());
        srb.addUrlMappings("/druid/*");
        srb.addInitParameter("loginUsername" ,"root");
        srb.addInitParameter("loginPassword" ,"xxxxxx");
        // 禁用重置数据功能
        srb.addInitParameter("resetEnable" ,"false");
        return srb ;
    }

    @Bean
    public FilterRegistrationBean druidWebStatFilter(){
        FilterRegistrationBean frb = new FilterRegistrationBean(new WebStatFilter());
        frb.addUrlPatterns("/*");
        frb.addInitParameter("exclusions","*.css,*.js,*.gif,*.jpg,*.png,*.ico,/druid/*");
        frb.setOrder(4);
        return frb;
    }

}