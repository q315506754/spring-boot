package com.zlikun.spring.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 类型安全的Bean
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 17:03
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data   // lombok 用法，默认添加 getter / setter 等方法
public class AppProps {

    private String author ;
    private String version ;

}
