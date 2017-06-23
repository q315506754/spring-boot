package com.zlikun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

/**
 * Web程序入口
 */
@SpringBootApplication
public class WebSpringBootApplication extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringBootApplication.class, args);
	}

	/**
	 * 添加静态资源处理器
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/") ;
	}

	/**
	 * 设置模板解析器
	 * @return
	 */
	@Bean
	public TemplateResolver viewResolver() {
		TemplateResolver resolver = new ServletContextTemplateResolver() ;
		resolver.setPrefix("/templates");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		return resolver ;
	}

	/**
	 * 设置模板引擎
	 * @return
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine engine = new SpringTemplateEngine() ;
		engine.setTemplateResolver(viewResolver());
		return engine ;
	}

	/**
	 * 设置 Thymeleaf 模板解析器
	 * @return
	 */
	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver() ;
		resolver.setTemplateEngine(templateEngine());
		return resolver ;
	}

}
