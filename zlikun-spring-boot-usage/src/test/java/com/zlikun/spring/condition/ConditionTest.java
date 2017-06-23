package com.zlikun.spring.condition;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:30
 */
public class ConditionTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ConditionConfig.class) ;

        ListService service = ctx.getBean(ListService.class) ;
        String cmd = service.showListCmd() ;

        // 当前操作系统：Windows 7，遍历目录命名：dir
        System.out.println(String.format("当前操作系统：%s，遍历目录命名：%s" ,ctx.getEnvironment().getProperty("os.name") ,cmd));

        ctx.close();

    }

}
