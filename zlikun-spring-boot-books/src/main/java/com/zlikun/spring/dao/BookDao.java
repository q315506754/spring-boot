package com.zlikun.spring.dao;

import com.zlikun.spring.model.Book;

import java.util.List;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:58
 */
public interface BookDao {

    Book get(long id) ;

    Book get(String isbn) ;

    List<Book> query(String keywords) ;

}
