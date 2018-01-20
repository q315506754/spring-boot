package com.zlikun.spring.conf;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StringRedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplateSlave;

    @Test
    public void test() {
        // 默认 StringRedisTemplate
        stringRedisTemplate.opsForValue().set("zlikun:string", "hello");
        assertEquals("hello", stringRedisTemplate.opsForValue().get("zlikun:string"));
        // 自定义 StringRedisTemplate
        stringRedisTemplateSlave.opsForValue().set("zlikun:string", "spring");
        assertEquals("spring", stringRedisTemplateSlave.opsForValue().get("zlikun:string"));
    }

}
