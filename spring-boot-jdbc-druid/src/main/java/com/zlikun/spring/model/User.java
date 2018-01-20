package com.zlikun.spring.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 16:00
 */
@Data
public class User {

    private Integer id;
    private String name;
    private String mobile;
    private String password;
    private LocalDateTime ctime;

}
