package com.zlikun.spring.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/6/23 9:26
 */
@Configuration
@ComponentScan("com.zlikun.spring.condition")
public class ConditionConfig {

    /**
     * 通过 @Conditional 注解控制具体实际化哪一个Bean <br>
     * 可以理解为：初始化当前Bean，需要满足条件：xxxxxx <br>
     * 所以这里可以实现基于当前系统是Windows/Linux来决定初始化哪一个Bean
     * @return
     */
    @Bean @Conditional(WindowsCondition.class)
    public ListService windowsListService() {
        return new WindowsListService() ;
    }

    @Bean @Conditional(LinuxCondition.class)
    public ListService linuxListService() {
        return new LinuxListService() ;
    }

}
