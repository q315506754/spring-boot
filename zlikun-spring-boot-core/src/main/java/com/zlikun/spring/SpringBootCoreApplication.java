package com.zlikun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
	}

}
