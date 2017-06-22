package com.zlikun.spring.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/22 18:54
 */
@Configuration
public class ProfileConfig {

    @Bean @Profile("dev")
    public ProfileBean devProfileBean() {
        return new ProfileBean("研发环境") ;
    }
    @Bean @Profile("prod")
    public ProfileBean prodProfileBean() {
        return new ProfileBean("生产环境") ;
    }

}
