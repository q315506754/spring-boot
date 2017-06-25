package com.zlikun.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:20
 */
@Data
public class User {

    private Long id ;
    private String name ;
    private String mobile ;
    private String email ;
    @JsonIgnore
    private String password ;
    private Date ctime ;

}