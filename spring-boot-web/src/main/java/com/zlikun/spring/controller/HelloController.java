package com.zlikun.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 17:25
 */
@RestController
public class HelloController {

    @GetMapping({ "/", "" })
    public String index() {
        return "Index .";
    }

    /**
     * http://localhost/hello?message=xxx
     * @param message
     * @return
     */
    @GetMapping("/hello")
    public String hello(String message) {
        return "Hello, " + message;
    }

}
