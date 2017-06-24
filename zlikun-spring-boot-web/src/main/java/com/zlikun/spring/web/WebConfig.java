package com.zlikun.spring.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sevlet、Filter、Listener等注册配置
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:09
 */
@Configuration
public class WebConfig {

    @Bean
    public HelloServlet helloServlet() {
        return new HelloServlet() ;
    }

    @Bean
    public HelloFilter helloFilter() {
        return new HelloFilter() ;
    }

    @Bean
    public HelloListener helloListener() {
        return new HelloListener() ;
    }

    /**
     * 注册HelloServlet，处理 /hello/* 请求
     * @return
     */
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(helloServlet() ,"/hello/*") ;
    }

    /**
     * 注册HelloFilter，过滤 /hello/* 请求
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean frb = new FilterRegistrationBean() ;
        frb.setFilter(helloFilter());
        frb.addUrlPatterns("/hello/*");
        frb.setOrder(2);
        return frb ;
    }

    /**
     * 注册 HelloListener
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        return new ServletListenerRegistrationBean<>(helloListener()) ;
    }

}