package com.zlikun.spring.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:22
 */
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.err.println("[Servlet] 执行Hello请求 ...");
        resp.getWriter().print("[Servlet] Hello " + req.getRequestURI());
    }
}