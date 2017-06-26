package com.zlikun.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/26 14:16
 */
@Repository("bookDao")
public class BookDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Resource
    JdbcTemplate jdbcTemplateOne ;

    @Resource
    JdbcTemplate jdbcTemplateTwo ;

    public void bind(JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) return ;
        this.jdbcTemplate = jdbcTemplate ;
    }

    /**
     * 创建一张表
     */
    public void createTable() {

        // 执行删除表操作
        jdbcTemplate.execute("DROP TABLE IF EXISTS TBL_BOOK");

        // 执行建表语句
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS TBL_BOOK (ID INT AUTO_INCREMENT PRIMARY KEY ,NAME VARCHAR(256) ,ISBN CHAR(13) ,PRICE FLOAT ,CTIME DATETIME)");

    }

    public void insert(String name ,String isbn ,float price) {
        jdbcTemplate.update("INSERT INTO TBL_BOOK (NAME ,ISBN ,PRICE ,CTIME) VALUES (? ,? ,? ,?)" ,name ,isbn ,price ,new Date()) ;
    }

}
