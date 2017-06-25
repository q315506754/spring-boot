package com.zlikun.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/25 11:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    // 模拟MVC对象，通过 MockMvcBuilders.webAppContextSetup(this.wac).build() ; 初始化
    private MockMvc mockMvc ;

    // 注入 WebApplicationContext
    @Autowired
    WebApplicationContext wac ;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build() ;
    }

    @Test
    public void get_by_mobile() throws Exception {
        String json = "{\"id\":1,\"name\":\"zlikun\",\"mobile\":\"12100000001\",\"email\":\"zlikun@zlikun.com\",\"ctime\":1498028400000}" ;
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/users/12100000001"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

}