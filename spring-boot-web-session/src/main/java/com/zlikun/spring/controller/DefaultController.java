package com.zlikun.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 17:25
 */
@RestController
public class DefaultController {

    @GetMapping({ "/", "" })
    public String index(HttpSession session) {
        session.setAttribute("author", "zlikun");
        return "Index .";
    }

}
