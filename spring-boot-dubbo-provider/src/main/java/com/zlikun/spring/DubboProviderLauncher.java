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
// 表示开启Dubbo功能，( dubbo provider服务可以使用或者不使用web容器 )
@EnableDubboConfiguration
public class DubboProviderLauncher {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderLauncher.class, args);
    }

}
