package com.zlikun.spring.scheduled;

import com.zlikun.spring.task.TaskConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:12
 */
public class ScheduledServiceTest {

    @Test
    public void test() throws InterruptedException {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ScheduledConfig.class) ;

        Thread.sleep(30000);
        ctx.close();
    }

}
