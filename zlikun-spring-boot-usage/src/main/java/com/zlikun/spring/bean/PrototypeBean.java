package com.zlikun.spring.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试用Bean，测试Bean的声明、范围及其它设定
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 14:23
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeBean {

    private static final AtomicInteger counter = new AtomicInteger() ;
    private int id ;

    public PrototypeBean() {
        this.id = counter.incrementAndGet() ;
    }

    public int getId() {
        return id;
    }
}
