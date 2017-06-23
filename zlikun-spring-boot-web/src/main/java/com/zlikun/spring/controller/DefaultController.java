package com.zlikun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 18:32
 */
@Controller
public class DefaultController {

    @RequestMapping("/")
    public String index() {
        return "index" ;
    }

    @ResponseBody
    @RequestMapping("/users")
    public Object users() {
        return Arrays.asList("jinx" ,"ashe") ;
    }

}
