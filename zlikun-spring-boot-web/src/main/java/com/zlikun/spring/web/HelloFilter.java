package com.zlikun.spring.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:22
 */
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.err.println("[Filter] 初始化过滤器 ...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.err.println("[Filter] 开始处理请求 ...");
        filterChain.doFilter(servletRequest ,servletResponse);
        System.err.println("[Filter] 结束处理请求 ...");
    }

    @Override
    public void destroy() {
        System.err.println("[Filter] 销毁过滤器 ...");
    }
}