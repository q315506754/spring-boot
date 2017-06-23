package com.zlikun.spring.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.*;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:44
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Configuration      // 组合 @Configuration 注解
@ComponentScan      // 组合 @ComponentScan 注解
public @interface ConfigurationWrapper {

    // 覆盖value参数，见：@ComponentScan 注解
    String [] value() default {} ;

}
