package com.zlikun.spring.spel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.util.Set;

/**
 * SpEL 使用示例
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:12
 */
@Configuration
@PropertySource("classpath:config.properties")
public class ElConfig {

    // 普通文本
    @Value("Hello ,Spring Boot !")
    public String normal ;

    // 从系统属性中获取属性值
    @Value("#{systemProperties['os.name']}")
    public String osName ;

    // 使用Java表达式获取值
    @Value("#{T(java.lang.Math).random() * 100.0}")
    public String randomNumber ;

    // 获取Bean属性(getter)
    @Value("#{singletonBean.id}")
    public int singletonBeanId ;

    // 获取classpath下资源文件(实际也可以使用文件相对路径、绝对路径表示)
    @Value("classpath:config.properties")
    public Resource configResource ;

    // 获取一个网络文件
    @Value("http://baidu.com")
    public Resource baiduResource ;

    // 从`config.properties`配置文件中读取属性，注意使用`${}`表达式
    @Value("${redis.host}")
    public String redisHost ;

    // 使用Java方法处理属性
    @Value("#{'${white.list}'.split(',')}")
    public Set<String> whites ;

    // 自动注入环境变量
    @Autowired
    public Environment environment ;

    /**
     * 使用 @PropertySource("classpath:config.properties") 引入的资源文件，使用@Value注入字段时，需要提供一个
     * PropertySourcesPlaceholderConfigurer 实例(Bean)
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer() ;
        configurer.setIgnoreResourceNotFound(true);
        configurer.setIgnoreUnresolvablePlaceholders(true);
        return configurer ;
    }

}
