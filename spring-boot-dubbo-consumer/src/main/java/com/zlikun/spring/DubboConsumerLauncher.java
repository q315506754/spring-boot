package com.zlikun.spring;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 10:44
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerLauncher.class, args);
    }

}
