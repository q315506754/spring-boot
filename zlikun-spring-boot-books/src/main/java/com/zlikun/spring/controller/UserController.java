package com.zlikun.spring.controller;

import com.zlikun.spring.dao.UserDao;
import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserDao userDao ;

    @RequestMapping("/{mobile}")
    public Object get(@PathVariable String mobile) {
        User user = userDao.get(mobile) ;
        return user ;
    }

}