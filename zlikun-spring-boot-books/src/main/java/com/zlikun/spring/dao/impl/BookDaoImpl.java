package com.zlikun.spring.dao.impl;

import com.zlikun.spring.dao.BookDao;
import com.zlikun.spring.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 11:04
 */
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

    Logger logger = LoggerFactory.getLogger(BookDaoImpl.class) ;

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Override
    public Book get(long id) {
        if (id <= 0) return null ;
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM TBL_BOOK WHERE ID = ?" , new BeanPropertyRowMapper<>(Book.class) ,id);
        } catch (EmptyResultDataAccessException e) {
            // 查询结果集为空，图书不存在
        } catch (DataAccessException e) {
            logger.warn("根据图书ID[{}]查询图书出错!" ,id ,e);
        }
        return null ;
    }

    @Override
    public Book get(String isbn) {
        if (isbn == null) return null ;
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM TBL_BOOK WHERE ISBN = ?" , new BeanPropertyRowMapper<>(Book.class) ,isbn);
        } catch (EmptyResultDataAccessException e) {
            // 查询结果集为空，图书不存在
        } catch (DataAccessException e) {
            logger.warn("根据图书ISBN编号[{}]查询图书出错!" ,isbn ,e);
        }
        return null ;
    }

    @Override
    public List<Book> query(String keywords) {
        if (keywords == null) return null ;
        try {
            return jdbcTemplate.query("SELECT * FROM TBL_BOOK WHERE NAME LIKE ?", new BeanPropertyRowMapper<>(Book.class) ,"%" + keywords + "%");
        } catch (EmptyResultDataAccessException e) {
            // 查询结果集为空，图书不存在
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null ;
    }
}