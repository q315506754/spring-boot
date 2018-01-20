package com.zlikun.spring.controller;

import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 16:22
 */
@RestController
public class UserController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public User index() {
        return jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE ID = 1",
                new BeanPropertyRowMapper<User>(User.class));
    }

}
