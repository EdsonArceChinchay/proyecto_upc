package com.tdp.ct.web.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        return DataSourceBuilder.create()
                .url(getValueConfig("application", "spring.datasource.url"))
                .username(getValueConfig("application", "spring.datasource.username"))
                .password(getValueConfig("application", "spring.datasource.password"))
                .driverClassName(getValueConfig("application", "spring.datasource.driver-class-name"))
                .build();
    }
}