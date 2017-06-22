package com.zlikun.spring.profile;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:57
 */
public class ProfileConfigTest {

    @Test
    public void test() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext() ;

//        ctx.getEnvironment().setActiveProfiles("dev");
        ctx.getEnvironment().setActiveProfiles("prod");
        ctx.register(ProfileConfig.class);
        ctx.refresh();

        // 研发环境 / 生产环境
        System.out.println(ctx.getBean(ProfileBean.class).toString());

        ctx.close();

    }

}
