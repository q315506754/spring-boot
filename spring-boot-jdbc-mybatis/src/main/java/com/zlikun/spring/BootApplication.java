package com.zlikun.spring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 09:50
 */
@SpringBootApplication
@MapperScan("com.zlikun.spring.mapper")
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
