package com.tdp.ct.web.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static com.tdp.ct.web.utils.FileUtils.getValueConfig;

@Configuration
public class DatabaseConfig {

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = DataSourceBuilder.create()
                .url(getValueConfig("application", "spring.datasource.url"))
                .username(getValueConfig("application", "spring.datasource.username"))
                .password(getValueConfig("application", "spring.datasource.password"))
                .driverClassName(getValueConfig("application", "spring.datasource.driver-class-name"))
                .build();
        try (Connection connection = dataSource.getConnection()) {
            if (connection != null) {
                System.out.println("Conexión a la base de datos exitosa!");
            } else {
                System.out.println("Fallo en la conexión a la base de datos.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return dataSource;
    }

    @PostConstruct
    public void checkProperties() {
        System.out.println("Datasource URL: " + System.getProperty("spring.datasource.url"));
    }
}