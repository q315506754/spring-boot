package com.zlikun.spring.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:04
 */
@Data
public class UserDto implements Serializable {

    private Long userId;
    private String name;
    private String mobile;
    private LocalDate birthday;

}
