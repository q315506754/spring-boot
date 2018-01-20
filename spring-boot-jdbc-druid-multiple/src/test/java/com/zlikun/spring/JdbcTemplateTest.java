package com.zlikun.spring;

import com.zlikun.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 15:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {

    @Resource
    private JdbcTemplate jdbcTemplateOne;

    @Resource
    private JdbcTemplate jdbcTemplateTwo;

    @Test
    @Transactional(transactionManager = "transactionManagerOne")
    public void one() {
        User user = jdbcTemplateOne.queryForObject("SELECT * FROM TBL_USER WHERE ID = 1",
                new BeanPropertyRowMapper<User>(User.class));
        assertNotNull(user);
        assertEquals("zlikun", user.getName());
    }

    @Test(expected = EmptyResultDataAccessException.class)
    @Transactional(transactionManager = "transactionManagerTwo")
    public void two() {
        User user = jdbcTemplateTwo.queryForObject("SELECT * FROM TBL_USER WHERE ID = 1",
                new BeanPropertyRowMapper<User>(User.class));
        assertNull(user);
    }


}
