package com.zlikun.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 11:21
 */
@Controller
public class SimpleController {

//    @RequestMapping("/")
//    public String index(HttpServletRequest request) {
//        System.err.println("程序运行根目录 -> " + request.getServletContext().getRealPath("/"));
//        return "index" ;
//    }

    @ResponseBody
    @RequestMapping("/users.json")
    public Object users(HttpServletRequest request) {
        System.err.println(request.getRequestURI());
        return Arrays.asList("jinx" ,"ashe") ;
    }

    @RequestMapping("/advice")
    public String advice(@ModelAttribute("msg") String msg) {
        throw new IllegalArgumentException("参数有误，来自@ModelAttribute：" + msg) ;
    }

}
