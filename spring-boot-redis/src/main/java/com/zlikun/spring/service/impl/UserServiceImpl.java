package com.zlikun.spring.service.impl;

import com.zlikun.spring.dto.UserDto;
import com.zlikun.spring.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:06
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Long save(UserDto user) {
        log.info("execute save .");
        // mock logic
        return 1L ;
    }

    @Override
    public void update(UserDto user) {
        log.info("execute update .");
        // mock logic
    }

    @Override
    public UserDto get(long userId) {
        log.info("execute get .");
        // mock logic
        UserDto user = new UserDto();
        user.setUserId(userId);
        user.setName("用户-" + userId);
        user.setMobile("110");
        user.setBirthday(LocalDate.of(2000, 1, 1));
        return user;
    }

    @Override
    public void delete(long userId) {
        log.info("execute delete .");
        // mock logic
    }

}
