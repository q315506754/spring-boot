package com.zlikun.spring.controller;

import com.zlikun.spring.dao.BookDao;
import com.zlikun.spring.dao.BorrowDao;
import com.zlikun.spring.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 15:26
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    BorrowDao borrowDao ;
    @Autowired
    BookDao bookDao ;

    @RequestMapping
    public Object borrow(@RequestParam long userId ,@RequestParam long bookId ,@RequestParam long during) {
        // 查询图书是否存在
        Book book = bookDao.get(bookId) ;
        if (book == null) {
            // TODO 图书不存在
            return "图书不存在" ;
        }
        // 判断图书是否空闲
        boolean isFree = borrowDao.isFree(bookId) ;
        if (!isFree) {
            // TODO 图书已被借出
            return "图书已被借出" ;
        }
        // 实现借书
        if (!borrowDao.borrow(bookId ,userId ,during)) {
            // TODO 借书失败(程序内部错误)
            return "借书失败(程序内部错误)" ;
        }

        // 返回借出图书
        return book ;
    }

}