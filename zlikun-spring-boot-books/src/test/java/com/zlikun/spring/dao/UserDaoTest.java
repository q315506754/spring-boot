package com.zlikun.spring.dao;

import com.zlikun.spring.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 10:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DaoConfig.class , DataSourceAutoConfiguration.class})
public class UserDaoTest {

    @Autowired
    UserDao userDao ;

    @Test
    public void get_by_id() {
        User user = userDao.get(1L) ;
        Assert.assertNotNull(user);
        Assert.assertEquals("zlikun" ,user.getName());
    }

    @Test
    public void get_by_mobile() {
        User user = userDao.get("12100000001") ;
        Assert.assertNotNull(user);
        Assert.assertEquals("zlikun" ,user.getName());
    }

    @Test
    public void get_by_mobile_not_exists() {
        User user = userDao.get("12100000000") ;
        Assert.assertNull(user);
    }

}