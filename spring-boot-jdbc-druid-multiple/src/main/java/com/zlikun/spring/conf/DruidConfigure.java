package com.zlikun.spring.conf;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 配置多个数据源，属性配置会自动注入到DataSource对象中
 * @author zlikun <zlikun-dev@hotmail.com>
 * @date 2018-01-20 16:41
 */
@Configuration
public class DruidConfigure {

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasource.druid.one")
    public DataSource dataSourceOne(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerOne() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSourceOne());
        return manager;
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplateOne() {
        return new JdbcTemplate(dataSourceOne());
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    public PlatformTransactionManager transactionManagerTwo() {
        DataSourceTransactionManager manager = new DataSourceTransactionManager(dataSourceTwo());
        return manager;
    }

    @Bean
    @Primary
    public JdbcTemplate jdbcTemplateTwo() {
        return new JdbcTemplate(dataSourceTwo());
    }

}
