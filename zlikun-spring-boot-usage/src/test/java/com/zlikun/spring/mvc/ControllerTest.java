package com.zlikun.spring.mvc;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 13:44
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MvcApplication.class})
// 声明加载的ApplicationContext是一个WebApplicationContext，其属性指定的是资源位置，默认为：src/main/webapp，这里使用src/main/resources
@WebAppConfiguration("src/main/resources")
public class ControllerTest {

    // 模拟MVC对象，通过 MockMvcBuilders.webAppContextSetup(this.wac).build() ; 初始化
    private MockMvc mockMvc ;

    // 注入 WebApplicationContext
    @Autowired
    WebApplicationContext wac ;

    // 注入 MockHttpSession ，这里仅用于演示用法，实际未使用
    @Autowired
    MockHttpSession session ;

    // 注入 MockHttpServletRequest ，这里仅用于演示用法，实际未使用
    @Autowired
    MockHttpServletRequest request ;

    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build() ;
    }

    @Test
    public void users() throws Exception {
        this.mockMvc
                // 模拟 GET /index 请求
                .perform(MockMvcRequestBuilders.get("/index"))
                // 预期响应状态为：200
                .andExpect(MockMvcResultMatchers.status().isOk())
                // 预期视图名称：index
                .andExpect(MockMvcResultMatchers.view().name("index"))
                // 预期页面转向实际路径：/WEB-INF/classes/views/index.jsp
                .andExpect(MockMvcResultMatchers.forwardedUrl("/WEB-INF/classes/views/index.jsp"))
                // 预期model里的值是：msg = 额外信息
                .andExpect(MockMvcResultMatchers.model().attribute("msg" ,"额外信息"))
                .andExpect(MockMvcResultMatchers.model().attribute("version" ,"1.0.0"));

    }

}
