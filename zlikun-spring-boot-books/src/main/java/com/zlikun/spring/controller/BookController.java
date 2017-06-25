package com.zlikun.spring.controller;

import com.zlikun.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 14:47
 */
@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookDao bookDao ;

    @RequestMapping(value = "/{id}")
    public Object get(@PathVariable long id) {
        return bookDao.get(id) ;
    }

    @RequestMapping(value = "/isbn/{isbn}")
    public Object get_by_isbn(@PathVariable String isbn) {
        return bookDao.get(isbn) ;
    }

    @RequestMapping(value = "/" ,params = "keywords")
    public Object query_by_keywords(@RequestParam String keywords) {
        return bookDao.query(keywords) ;
    }



}