package com.zlikun.spring.bean;

import com.zlikun.spring.WebSpringBootApplication;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 14:39
 */
public class BeanTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WebSpringBootApplication.class) ;

        // Prototype 作用范围下，每次都获取新实例
        Assert.assertEquals(1 ,ctx.getBean(PrototypeBean.class).getId()); ;
        Assert.assertEquals(2 ,ctx.getBean(PrototypeBean.class).getId()); ;
        Assert.assertEquals(3 ,ctx.getBean(PrototypeBean.class).getId()); ;

        // Singleton  作用范围下，在Spring容器范围内是单例的
        Assert.assertEquals(1 ,ctx.getBean(SingletonBean.class).getId()); ;
        Assert.assertEquals(1 ,ctx.getBean(SingletonBean.class).getId()); ;
        Assert.assertEquals(1 ,ctx.getBean(SingletonBean.class).getId()); ;

    }

    @Test
    public void lifecycle() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(WebSpringBootApplication.class) ;

        System.err.println("启动 AnnotationConfigApplicationContext ...");
        ctx.start();

        // 执行构造方法 ...
        // 执行初始化方法 ...
        // 销毁方法没见执行 ???
        BeanLifecycle beanLifecycle = ctx.getBean(BeanLifecycle.class) ;
        System.out.println(beanLifecycle);

        // 启动 AnnotationConfigApplicationContext ...
        // 停止 AnnotationConfigApplicationContext ...
        System.err.println("停止 AnnotationConfigApplicationContext ...");
        ctx.stop();

        // 关闭 AnnotationConfigApplicationContext ...
        // 执行销毁方法 ...
        System.err.println("关闭 AnnotationConfigApplicationContext ...");
        ctx.close();
    }

}
