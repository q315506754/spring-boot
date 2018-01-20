package com.zlikun.spring.service;

import com.zlikun.spring.dto.UserDto;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * 使用 spring-cache 注解缓存增强
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 14:04
 */
public interface UserService {

    Long save(UserDto user) ;

    @CachePut(value = "service", key = "'user:' + #userId", unless = "#user != null && #user.userId != null")
    void update(UserDto user) ;

    /**
     * `unless` 属性是针对方法返回值的，所以设定后，方法会无条件的执行原有逻辑
     * @param userId
     * @return
     */
    @Cacheable(value = "service", key = "'user:' + #userId"/*, unless = "#result != null"*/)
    UserDto get(long userId);

    @CacheEvict(value = "service", key = "'user:' + #userId")
    void delete(long userId);

}
