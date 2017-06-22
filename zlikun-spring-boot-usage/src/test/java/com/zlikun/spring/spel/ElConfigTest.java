package com.zlikun.spring.spel;

import com.zlikun.spring.WebSpringBootApplication;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:34
 */
public class ElConfigTest {

    @Test
    public void test() throws IOException {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WebSpringBootApplication.class) ;

        ElConfig config = ctx.getBean(ElConfig.class) ;

        // Hello ,Spring Boot !
        System.out.println(config.normal);
        // Windows 7
        System.out.println(config.osName);
        // 1.8832880724905188
        System.out.println(config.randomNumber);
        // 1
        System.out.println(config.singletonBeanId);
        // file:/F:/studio/zlikun/git/zlikun-spring-boot/zlikun-spring-boot-usage/target/classes/config.properties
        System.out.println(config.configResource.getURI());
        // http://baidu.com
        System.out.println(config.baiduResource.getURI());
        // 192.168.9.205
        System.out.println(config.redisHost);
        // [ashe, jinx]
        System.out.println(config.whites);
        // C:\Program Files\Java\jdk1.8.0_102
        System.out.println(config.environment.getProperty("JAVA_HOME"));

    }

}
