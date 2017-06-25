package com.zlikun.spring.dao.impl;

import com.zlikun.spring.dao.UserDao;
import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:21
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Override
    public User get(long userId) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE ID = ?"
                , new BeanPropertyRowMapper<>(User.class) ,userId) ;
        return user ;
    }

    @Override
    public User get(String mobile) {
        User user = jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE MOBILE = ?"
                , new BeanPropertyRowMapper<>(User.class) ,mobile) ;
        return user ;
    }
}