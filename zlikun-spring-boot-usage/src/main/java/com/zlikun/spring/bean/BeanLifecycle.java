package com.zlikun.spring.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:44
 */
@Component
public class BeanLifecycle {

    // 与 @Bean 注解中的 initMethod 属性等同
    @PostConstruct
    public void init() {
        System.err.println("执行初始化方法 ...");
    }

    public BeanLifecycle() {
        System.err.println("执行构造方法 ...");
    }

    // 与 @Bean 注解中的 destroyMethod 属性等同
    @PreDestroy
    public void destroy() {
        System.err.println("执行销毁方法 ...");
    }

}
