package com.zlikun.spring.model;

import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 09:54
 */
@Data
public class User {

    private Long id;
    private String name;
    private String mobile;
    private String password;
    private LocalDateTime ctime;

}
