package com.zlikun.learning.receiver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static com.zlikun.learning.conf.RabbitConfigure.DEFAULT_QUEUE_NAME;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-05 16:51
 */
@Slf4j
@Component
public class SimpleMessageReceiver {

    /**
     * RabbitListener 实际只能用于方法级别，用于类级别时会报错
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = DEFAULT_QUEUE_NAME)
    public void print(Message message) {
        log.info("receive message : {}", new String(message.getBody()));
    }

}
