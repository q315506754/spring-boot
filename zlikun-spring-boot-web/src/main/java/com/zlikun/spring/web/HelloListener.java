package com.zlikun.spring.web;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:25
 */
public class HelloListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.err.println("[Listener] 销毁请求 ...");
    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.err.println("[Listener] 初始化请求 ...");
    }
}