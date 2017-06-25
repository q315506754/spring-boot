package com.zlikun.spring.model;

import lombok.Data;

import java.util.Date;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:59
 */
@Data
public class Book {

    private Long id ;
    private String name ;
    private String isbn ;
    private Float price ;
    private Date ctime ;

}