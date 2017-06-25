package com.zlikun.spring.dao;

import com.zlikun.spring.model.User;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:19
 */
public interface UserDao {

    User get(long id) ;

    User get(String mobile) ;

}
