package com.zlikun.spring.props;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 17:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppPropsTest {

    @Autowired
    AppProps props ;

    @Test
    public void test() {

        Assert.assertEquals("zlikun" ,props.getAuthor());
        Assert.assertEquals("1.0.0" ,props.getVersion());

    }

}
