package com.zlikun.learning.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-02-05 17:24
 */
@ConditionalOnBean(RabbitTemplate.class)
@Configuration
public class RabbitConfigure {

    public static final String DEFAULT_EXCHANGE = "direct_exchange";
    public static final String DEFAULT_QUEUE_NAME = "A.TEST";

    /**
     * 配置默认信道(直连，点对点队列形式)
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DEFAULT_EXCHANGE, false, true);
    }

    @Bean
    public Queue aTestQueue() {
        return new Queue(DEFAULT_QUEUE_NAME, false);
    }

    @Bean
    public Binding aTestBinding() {
        return BindingBuilder.bind(aTestQueue()).to(directExchange()).with(DEFAULT_QUEUE_NAME);
    }

}
