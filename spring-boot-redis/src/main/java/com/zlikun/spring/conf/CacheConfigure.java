package com.zlikun.spring.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:18
 */
@Configuration
@EnableCaching  // 开启AOP缓存支持
public class CacheConfigure {

    @Autowired
    private RedisTemplate redisTemplate;

//    // 与 org.springframework.boot.autoconfigure.cache.RedisCacheConfiguration 类功能一致(默认有配置，除非有特定需求，否则无需配置)
//    @Bean
//    public CacheManager cacheManager() {
//        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//        cacheManager.setDefaultExpiration(15);  // 为了便于测试，缓存默认过期时间为15秒
//        return cacheManager;
//    }

}
