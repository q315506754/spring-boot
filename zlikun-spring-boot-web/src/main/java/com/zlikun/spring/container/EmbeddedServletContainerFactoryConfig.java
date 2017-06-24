package com.zlikun.spring.container;

import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/24 12:52
 */
@Configuration
public class EmbeddedServletContainerFactoryConfig {

//    /**
//     * 配置 Jetty 内嵌WEB服务器
//     * @return
//     */
//    @Bean
//    public JettyEmbeddedServletContainerFactory jettyServletContainerFactory() {
//        JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory() ;
//        factory.setPort(10010); // 将被server.port配置覆盖
//        factory.setSessionTimeout(15 , TimeUnit.MINUTES);
//        return factory ;
//    }

    @Bean
    public TomcatEmbeddedServletContainerFactory tomcatServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory() ;
        factory.setPort(10020);
        factory.setSessionTimeout(15 , TimeUnit.MINUTES);
        return factory ;
    }

//    @Bean
//    public UndertowEmbeddedServletContainerFactory undertowServletContainerFactory() {
//        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
//        factory.setPort(10030);
//        factory.setSessionTimeout(15 , TimeUnit.MINUTES);
//        return factory ;
//    }

}