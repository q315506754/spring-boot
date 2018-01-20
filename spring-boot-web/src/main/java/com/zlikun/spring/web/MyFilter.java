package com.zlikun.spring.web;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 17:38
 */
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        log.info("init - version = {}", config.getInitParameter("version"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter - uri = {}", ((HttpServletRequest) request).getRequestURI());
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy .");
    }

}
