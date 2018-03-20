package com.zlikun.spring.mapper;

import com.zlikun.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-03-20 09:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void get() {
        User model = userMapper.get(1L);
        assertNotNull(model);
        assertEquals("zlikun", model.getName());
    }

    @Test
    public void list() {
        List<User> list = userMapper.list(0, 3);
        assertNotNull(list);
        assertFalse(list.isEmpty());
        list.forEach(System.out::println);
    }

}