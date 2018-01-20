package com.zlikun.spring;

import com.zlikun.spring.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * JdbcTemplate为版本装配(系统中存在DataSource的实例即可)
 * @see org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 15:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTemplateTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        User user = jdbcTemplate.queryForObject("SELECT * FROM TBL_USER WHERE ID = 1",
                new BeanPropertyRowMapper<User>(User.class));
        assertNotNull(user);
        assertEquals("zlikun", user.getName());
    }


}
