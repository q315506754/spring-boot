package com.zlikun.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 11:06
 */
@Configuration
@EnableWebMvc
@SpringBootApplication
@ComponentScan("com.zlikun.spring.mvc")
public class MvcApplication extends WebMvcConfigurerAdapter {

    /**
     * 视图解析器Bean声明
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver() ;
        resolver.setPrefix("/WEB-INF/classes/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver ;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        // 添加静态资源处理器
        // resourceHandler 配置对外访问路径，resourceLocations 配置文件存放目录
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/") ;
    }

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

}
