package com.zlikun.spring.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @see org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration
 * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:37
 */
@Configuration
public class RedisConfigure {

    /**
     * spring-boot 自动配置的 redisConnectionFactory ，其被标记为：@ConditionalOnMissingBean(RedisConnectionFactory.class)
     * 所以如果一旦在其它地方配置了 redisConnectionFactory， 默认配置将不生效
     * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.RedisConnectionConfiguration#redisConnectionFactory()
     */
    @Autowired
    private JedisConnectionFactory redisConnectionFactory;

    /**
     * 与 redisConnectionFactory 同理，这里一旦配置，默认配置将不再生效，这里配置默认节点
     * @see org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration.RedisConfiguration#stringRedisTemplate(RedisConnectionFactory)
     * @return
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(){
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    /**
     * 这里配置从节点，同理也可以山配置其它节点，如果配置属性不同(实际如果相同就没必要配置多个啦)，
     * redisConnectionFactory 需要配置多个(实际是其内部的RedisProperties实例需要配置多个)
     * 这里仅作演示，所以复用了同一个配置来实现两个Bean的配置
     * @return
     */
    @Bean
    public StringRedisTemplate stringRedisTemplateSlave() {
        StringRedisTemplate template = new StringRedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

}
