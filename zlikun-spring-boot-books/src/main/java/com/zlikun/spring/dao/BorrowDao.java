package com.zlikun.spring.dao;

import org.springframework.transaction.annotation.Transactional;

/**
 * 借书动作接口
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 15:09
 */
public interface BorrowDao {

    /**
     * 图书是否空闲(处于可借出状态)
     * @param bookId
     * @return
     */
    boolean isFree(long bookId) ;

    /**
     * 借书动作
     * @param bookId
     * @param userId
     * @param during
     * @return
     */
    @Transactional
    boolean borrow(long bookId ,long userId ,long during) ;

}
