package com.zlikun.spring.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 用户API
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 14:55
 */
@RestController
@RequestMapping("/users")
public class UserController {

    public UserController() {
        System.err.println("xxxxxxxxxxxxxxxxxx");
    }

    @RequestMapping("/{mobile}")
    public Object get(@PathVariable String mobile) {

        return Arrays.asList("jinx" ,"ashe") ;
    }

}