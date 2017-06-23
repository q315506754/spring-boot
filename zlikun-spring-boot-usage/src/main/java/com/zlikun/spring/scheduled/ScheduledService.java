package com.zlikun.spring.scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:07
 */
@Component
public class ScheduledService {

    private static final DateFormat format = new SimpleDateFormat("HH:mm:ss.SSS") ;

    @Scheduled(fixedRate = 5000)
    public void printCurrentTime() {
        System.out.println("每隔5秒执行一次：" + format.format(new Date()));
    }

    @Scheduled(cron = "0/3 * * * * *")
    public void fixTimeExecution() {
        System.out.println("每隔3秒执行一次：" + format.format(new Date()));
    }

}
