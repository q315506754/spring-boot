package com.zlikun.spring.annotation;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:48
 */
public class AnnotationTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(HelloConfig.class) ;
        // Hello girl !
        ctx.getBean(HelloService.class).say("girl !");
        ctx.close();
    }

}
