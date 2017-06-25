package com.zlikun.spring.dao.impl;

import com.zlikun.spring.dao.BorrowDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 15:13
 */
@Repository("borrowDao")
public class BorrowDaoImpl implements BorrowDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    @Override
    public boolean isFree(long bookId) {
        // 查询图书借阅情况，存在借阅且未归还则表示图书非空闲
        int count = jdbcTemplate.queryForObject("SELECT COUNT(1) FROM TBL_BORROW WHERE BOOK_ID = ? AND RETURN_TIME IS NOT NULL" ,Integer.class ,bookId) ;
        return count == 0;
    }

    @Override
    public boolean borrow(long bookId, long userId ,long during) {
        if (bookId <= 0 || userId <= 0 || during <= 0) return false ;
        return jdbcTemplate.update("INSERT INTO TBL_BORROW (USER_ID, BOOK_ID, CTIME, DURING) VALUES (? ,? ,? ,?)" ,userId ,bookId ,new Date(),during) == 1 ;
    }
}