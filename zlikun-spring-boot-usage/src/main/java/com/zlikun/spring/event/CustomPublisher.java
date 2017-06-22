package com.zlikun.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 19:24
 */
@Component
public class CustomPublisher {

    @Autowired
    ApplicationContext applicationContext ;

    public void publish(String message) {
        applicationContext.publishEvent(new CustomEvent(this ,message));
    }

}
