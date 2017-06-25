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
public class BookControllerTest {

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
    public void get() throws Exception {
        String json = "{\"id\":1,\"name\":\"Spring Cloud微服务实战\",\"isbn\":\"9787121313011\",\"price\":89.0,\"ctime\":1498028400000}" ;
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/books/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

    @Test
    public void get_by_isbn() throws Exception {
        String json = "{\"id\":1,\"name\":\"Spring Cloud微服务实战\",\"isbn\":\"9787121313011\",\"price\":89.0,\"ctime\":1498028400000}" ;
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/books/isbn/9787121313011"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

    @Test
    public void query_by_keywords() throws Exception {
        String json = "[{\"id\":1,\"name\":\"Spring Cloud微服务实战\",\"isbn\":\"9787121313011\",\"price\":89.0,\"ctime\":1498028400000}," +
                "{\"id\":2,\"name\":\"Spring Cloud与Docker微服务架构实战\",\"isbn\":\"9787121312717\",\"price\":69.0,\"ctime\":1498028400000}]" ;
        this.mockMvc
                .perform(MockMvcRequestBuilders.get("/books/?keywords=微服务"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(json));
    }

}