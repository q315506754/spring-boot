package com.zlikun.spring.conf;

import com.zlikun.spring.web.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 过滤器、拦截器、监听器等WEB组件配置
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 17:37
 */
@Configuration
public class WebConfigure {

    /**
     * 注册一个过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 设定过滤器实例
        registration.setFilter(new MyFilter());
        // 指定过滤器拦截请求
        registration.addUrlPatterns("/*");
        // 过滤器初始化参数
        registration.addInitParameter("version", "v1.0");
        // 过滤器名称
        registration.setName("myFilter");
        // 过滤器执行顺序
        registration.setOrder(1);
        return registration;
    }

}
