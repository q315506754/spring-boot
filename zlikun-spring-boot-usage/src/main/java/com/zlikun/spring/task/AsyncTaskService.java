package com.zlikun.spring.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 8:55
 */
@Component
//@Async  // 类级别时@Async注解表示该类所有方法都是异步方法
public class AsyncTaskService {

    @Async  // 方法级别@Async注解表示该方法为异步方法
    public void executeAsyncTask(int i) {
        System.out.println("执行异步任务 ：" + i);
    }

    @Async
    public void executeAsyncTaskPlus(int i) {
        System.out.println("执行异步任务 + 1 ：" + (i + 1));
    }

}
