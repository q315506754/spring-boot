package com.zlikun.spring.dao.impl;

import com.zlikun.spring.dao.UserDao;
import com.zlikun.spring.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:21
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    Logger logger = LoggerFactory.getLogger(UserDaoImpl.class) ;

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Override
    public User get(long id) {
        if (id <= 0) return null ;
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE ID = ?"
                    , new BeanPropertyRowMapper<>(User.class) , id);
        } catch (EmptyResultDataAccessException e) {
            // 查询结果集为空，用户不存在
        } catch (DataAccessException e) {
            logger.warn("根据用户ID[{}]查询用户出错!" ,id ,e);
        }
        return null ;
    }

    @Override
    public User get(String mobile) {
        if (mobile == null) return null ;
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE MOBILE = ?"
                    , new BeanPropertyRowMapper<>(User.class) ,mobile);
        } catch (EmptyResultDataAccessException e) {
            // 查询结果集为空，用户不存在
        } catch (DataAccessException e) {
            logger.warn("根据手机[{}]查询用户出错!" ,mobile ,e);
        }
        return null ;
    }
}