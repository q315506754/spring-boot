package com.zlikun.spring;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @SpringBootApplication 标记的类通常包含一个main()，是程序的入口 <br>
 *     该注解是spring-boot的核心注解，是一个组合注解，包含：
 *     @Configuration
 *     @EnableAutoConfiguration
 *     @ComponentScan
 *     所以不使用该注解，直接使用上面三个注解也能实现相同效果
 *     该注解默认扫描注解所在类的同级包，所以这里实际可以不配置扫描包
 *     `exclude`参数则用于关闭特定的自定配置类，如：DataSourceAutoConfiguration
 */
@SpringBootApplication
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
//@SpringBootApplication(scanBasePackages = {"com.zlikun.spring"})

// 引入xml配置文件(spring-boot不提倡使用xml配置，应尽量使用java和注解配置)
@ImportResource("classpath:spring/beans.xml")
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootCoreApplication.class) ;

		// 关闭 Banner
//		app.setBannerMode(Banner.Mode.OFF);
		app.setBannerMode(Banner.Mode.CONSOLE);

//		// 启动 spring-boot
//		SpringApplication.run(SpringBootCoreApplication.class, args);
		// 另一种启动方法
		app.run(args) ;
	}

}
