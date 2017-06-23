package com.zlikun.spring.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
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
public class MvcApplication {

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

    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class, args);
    }

}
