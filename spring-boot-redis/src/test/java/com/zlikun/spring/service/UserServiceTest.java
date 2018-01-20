package com.zlikun.spring.service;

import com.zlikun.spring.dto.UserDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

/**
 * 通过观察输出日志判断缓存使用情况
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void save() {
        UserDto user = new UserDto();
        user.setName("zlikun");
        user.setMobile("119");
        user.setBirthday(LocalDate.of(2018, 1, 1));
        Long userId = userService.save(user);
        assertNotNull(userId);
    }

    @Test
    public void update() {
        UserDto user = new UserDto();
        user.setUserId(1L);
        user.setName("Ashe");
        userService.update(user);
    }

    /**
     * 通过测试可以发现短时间内连续请求，只会走一次原实现(其它走缓存，因为缓存时间较短，所以需要连续请求，以方便观察效果)
     */
    @Test
    public void get() {
        UserDto user = userService.get(1L);
        assertNotNull(user);
    }

    @Test
    public void delete() {
        userService.delete(7L);
    }
}