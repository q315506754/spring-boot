package com.zlikun.spring.task;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 8:59
 */
public class AsyncTaskServiceTest {

    @Test
    public void test() {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TaskConfig.class) ;
        AsyncTaskService service = ctx.getBean(AsyncTaskService.class) ;

        /**
         * 由于方法是异步的，所以这里的代码实际执行顺序，并非代码字面上的顺序
         */
        for (int i = 0; i < 10; i++) {
            service.executeAsyncTask(i);
            service.executeAsyncTaskPlus(i);
        }

        ctx.close();

    }

}
