package com.zlikun.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 19:22
 */
@Component
public class CustomListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent customEvent) {
        System.out.println(String.format("接收到事件监听消息：%s" ,customEvent.getMessage()));
    }
}
