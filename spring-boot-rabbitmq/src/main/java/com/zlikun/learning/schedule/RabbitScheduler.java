package com.zlikun.learning.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 用于定时发送消息，测试消息收发
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-05 17:14
 */
@Slf4j
@Component
public class RabbitScheduler {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000)
    public void send() {
        String message = "The timestamp is " + System.currentTimeMillis();
        rabbitTemplate.convertAndSend("direct_exchange",
                "", message);
        log.info("send message : {}", message);
    }

}
