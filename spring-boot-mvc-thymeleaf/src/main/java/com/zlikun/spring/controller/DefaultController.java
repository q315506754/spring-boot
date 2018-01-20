package com.zlikun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 18:12
 */
@Controller
public class DefaultController {

    @GetMapping({ "/", "" })
    public String index() {
        return "index";
    }

}
