package com.zlikun.spring.profile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 17:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfileTest {

    @Value("${codis.host}")
    String host ;
    @Value("${codis.port}")
    String port ;

    @Test
    public void test() {

        System.out.println(host);   // 192.168.9.205
        System.out.println(port);   // 6379

    }

}
