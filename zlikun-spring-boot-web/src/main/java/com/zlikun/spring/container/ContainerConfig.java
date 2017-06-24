package com.zlikun.spring.container;

import org.springframework.boot.context.embedded.Compression;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 使用Java配置WEB容器
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:44
 */
//@Component    // 这里仅作演示用，把 @Component 注解关闭后，该配置将不再生效
public class ContainerConfig implements EmbeddedServletContainerCustomizer {

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(9000);
        container.setContextPath("/tomcat");
        container.setSessionTimeout(30 , TimeUnit.MINUTES);
        // ... ...
    }

}