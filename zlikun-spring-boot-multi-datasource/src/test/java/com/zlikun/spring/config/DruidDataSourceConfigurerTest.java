package com.zlikun.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/26 9:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DruidDataSourceConfigurerTest {

    @Resource
//    @Autowired  // 由于指定了 dataSourceOne 为 @Primary，所以使用 @Autowired 注解时，将自动注入该Bean
    DruidDataSource dataSourceOne ;

    @Resource
    DruidDataSource dataSourceTwo ;

    @Test
    public void test() {

        Assert.assertEquals(20 ,dataSourceOne.getMaxActive());
        Assert.assertEquals(30 ,dataSourceTwo.getMaxActive());

    }

}
