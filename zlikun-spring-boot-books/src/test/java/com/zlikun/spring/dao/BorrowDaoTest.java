package com.zlikun.spring.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 15:23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DaoConfig.class ,DataSourceAutoConfiguration.class})
public class BorrowDaoTest {

    @Autowired
    BorrowDao borrowDao ;

    @Test
    public void isFree() {
        Assert.assertTrue(borrowDao.isFree(1024L));
    }

    @Test @Transactional @Rollback(true)
    public void borrow() {
        Assert.assertTrue(borrowDao.borrow(1L ,1L ,7 * 24 * 3600L));
    }

}