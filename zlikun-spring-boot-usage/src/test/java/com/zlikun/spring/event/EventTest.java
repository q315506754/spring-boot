package com.zlikun.spring.event;

import com.zlikun.spring.WebSpringBootApplication;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 19:25
 */
public class EventTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WebSpringBootApplication.class) ;

        // 接收到事件监听消息：Hello Spring Boot !
        ctx.getBean(CustomPublisher.class).publish("Hello Spring Boot !");

        ctx.close();
    }

}
