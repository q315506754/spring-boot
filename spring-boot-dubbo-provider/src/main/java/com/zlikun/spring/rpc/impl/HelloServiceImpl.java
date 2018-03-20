package com.zlikun.spring.rpc.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.zlikun.spring.rpc.HelloService;
import org.springframework.stereotype.Component;

/**
 * 发布Dubbo服务
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 10:54
 */
@Component
@Service(interfaceClass = HelloService.class, group = "dev", version = "1.0.0")
public class HelloServiceImpl implements HelloService {

    @Override
    public String say(String name) {
        return name + " say 'Hello' !";
    }

}
