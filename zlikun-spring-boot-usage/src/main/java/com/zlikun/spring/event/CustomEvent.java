package com.zlikun.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 19:20
 */
public class CustomEvent extends ApplicationEvent {

    private String message ;

    public CustomEvent(Object source ,String message) {
        super(source);
        this.message = message ;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
