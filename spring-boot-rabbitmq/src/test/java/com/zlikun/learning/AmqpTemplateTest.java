package com.zlikun.learning;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-05 09:25
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class AmqpTemplateTest {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void send() {

        // 第一组发送API
        Message message = MessageBuilder.withBody("Hello RabbitMQ !".getBytes()).build();
        // amqpTemplate.send(message);
        // amqpTemplate.send("", message);
        amqpTemplate.send("direct_exchange", "", message);

        // 第二组发送API
        // amqpTemplate.convertAndSend("Hello RabbitMQ !");
        // amqpTemplate.convertAndSend("", "Hello RabbitMQ !");
        amqpTemplate.convertAndSend("direct_exchange", "", "Hello RabbitMQ !");

    }

    @Test
    public void get() {
        Message message = amqpTemplate.receive("A.TEST", 3000L);
        if (message != null) {
            log.info("receive message : {}", new String(message.getBody()));
        } else {
            log.info("receive message : {}", "nothing");
        }
    }

}
