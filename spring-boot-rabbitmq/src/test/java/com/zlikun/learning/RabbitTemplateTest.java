package com.zlikun.learning;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.zlikun.learning.conf.RabbitConfigure.DEFAULT_EXCHANGE;
import static com.zlikun.learning.conf.RabbitConfigure.DEFAULT_QUEUE_NAME;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-05 09:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitTemplateTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {

        // 第一组发送API
        Message message = MessageBuilder.withBody("Hello RabbitMQ !".getBytes()).build();
        rabbitTemplate.send(message);
        rabbitTemplate.send(DEFAULT_QUEUE_NAME, message);
        rabbitTemplate.send(DEFAULT_EXCHANGE, DEFAULT_QUEUE_NAME, message);

        // 第二组发送API
        rabbitTemplate.convertAndSend("Hello RabbitMQ !");
        rabbitTemplate.convertAndSend(DEFAULT_QUEUE_NAME, "Hello RabbitMQ !");
        rabbitTemplate.convertAndSend(DEFAULT_EXCHANGE, DEFAULT_QUEUE_NAME, "Hello RabbitMQ !");

    }

}
