package org.example.main.configuration;

import lombok.RequiredArgsConstructor;
import org.example.main.util.ConnectionHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class DatabaseConfig {
    private final ConnectionHolder connectionHolder;
    @Value("${database.url}")
    private String URL;
    @Value("${database.username}")
    private String USERNAME;
    @Value("${database.password}")
    private String PASSWORD;
    @Bean
    public Connection createConnection() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
        Connection connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        connectionHolder.getConnection();
        return connection;
    }
}
