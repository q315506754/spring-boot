package com.zlikun.spring.mvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过继承HandlerInterceptorAdapter类实现一个拦截器
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 11:59
 */
public class LoggerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class) ;

    /**
     * 前置处理逻辑
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("start" ,System.currentTimeMillis());
        logger.info("开始处理请求：{}" ,request.getRequestURI());
        return super.preHandle(request, response, handler);
    }

    /**
     * 后置处理逻辑
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("完成请求处理：{}" ,request.getRequestURI());
        Long start = (Long) request.getAttribute("start");
        request.removeAttribute("start");
        logger.info("请求[{}]执行耗时：{} 毫秒!" ,request.getRequestURI() ,System.currentTimeMillis() - start);
        super.postHandle(request, response, handler, modelAndView);
    }
}
