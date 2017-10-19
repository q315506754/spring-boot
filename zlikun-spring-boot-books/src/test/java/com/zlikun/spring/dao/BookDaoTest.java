package com.zlikun.spring.dao;

import com.zlikun.spring.model.Book;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 11:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DaoConfig.class , DataSourceAutoConfiguration.class})
public class BookDaoTest {

    @Autowired
    BookDao bookDao ;

    @Test
    public void get_by_id() {
        Book book = bookDao.get(1L) ;
        Assert.assertNotNull(book);
        Assert.assertEquals("Spring Cloud微服务实战" ,book.getName());
    }

    @Test
    public void get_by_isbn() {
        Book book = bookDao.get("9787121313011") ;
        Assert.assertNotNull(book);
        Assert.assertEquals("Spring Cloud微服务实战" ,book.getName());
    }

    @Test
    public void query() {
        List<Book> list = bookDao.query("Spring") ;
        Assert.assertNotNull(list);
        Assert.assertFalse(list.isEmpty());
    }

}