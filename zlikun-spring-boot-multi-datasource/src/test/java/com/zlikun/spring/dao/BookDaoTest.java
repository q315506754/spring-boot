package com.zlikun.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/26 14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao ;

    @Resource
    JdbcTemplate jdbcTemplateOne ;

    @Resource
    JdbcTemplate jdbcTemplateTwo ;

    @Test
    public void test() {

        // 数据源 - 1
        select(jdbcTemplateOne) ;
        // 数据源 - 2
        select(jdbcTemplateTwo) ;

    }

    private void select(JdbcTemplate jdbcTemplate) {
        bookDao.bind(jdbcTemplate);
        bookDao.createTable();

        bookDao.insert("Spring Cloud微服务实战" ,"9787121313011" ,89.0F);
    }

}
