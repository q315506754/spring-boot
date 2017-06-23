package com.zlikun.spring.mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * WebApplicationInitializer 接口是Spring提供用来配置Servlet 3.0+配置的接口，替代web.xml的作用<br>
 * 实现此接口将自动被SpringServletContainerInitializer(用来启动Servlet3.0+容器)获取到
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 11:12
 */
public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(MvcApplication.class);
        // 新建WebApplicationContext，注册配置类，并将和当前servletContext关联
        ctx.setServletContext(servletContext) ;

        // 注册字符集过滤器
        FilterRegistration.Dynamic filter = servletContext.addFilter("encoding" ,new CharacterEncodingFilter("UTF-8" ,true)) ;
        filter.addMappingForServletNames(EnumSet.of(DispatcherType.FORWARD ,DispatcherType.INCLUDE ,DispatcherType.REQUEST) ,true ,"dispatcher");

        // 注册Spring MVC 的DispatcherServlet
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher" ,new DispatcherServlet(ctx)) ;
        servlet.addMapping("/") ;
        servlet.setLoadOnStartup(1);
    }
}
