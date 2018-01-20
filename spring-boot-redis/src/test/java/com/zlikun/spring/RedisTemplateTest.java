package com.zlikun.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Test
    public void test() {

        redisTemplate.opsForValue().set("zlikun:string" ,"+OK");
        assertEquals("+OK", redisTemplate.opsForValue().get("zlikun:string"));

    }

}
