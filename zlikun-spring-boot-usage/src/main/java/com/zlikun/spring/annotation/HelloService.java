package com.zlikun.spring.annotation;

import org.springframework.stereotype.Component;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:47
 */
@Component
public class HelloService {

    public void say(String message) {
        System.out.println("Hello " + message);
    }

}
