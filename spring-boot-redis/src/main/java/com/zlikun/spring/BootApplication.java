package com.zlikun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 12:17
 */
@SpringBootApplication
@EnableCaching  // 开启AOP缓存支持
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

}
