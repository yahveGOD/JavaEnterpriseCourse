package org.example.main.configuration;

import liquibase.integration.spring.SpringLiquibase;
import liquibase.pro.packaged.V;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class LiquibaseConfig {
    @Value("${database.url}")
    private String URL;
    @Value("${database.username}")
    private String USERNAME;
    @Value("${database.password}")
    private String PASSWORD;
    @Value("${database.driver}")
    private String DRIVER;
    @Bean
    public SpringLiquibase liquibase() {
        SpringLiquibase liquibase = new SpringLiquibase();

        liquibase.setChangeLog("classpath:changelog-master.xml");
        liquibase.setDataSource(dataSource());

        return liquibase;
    }

    @Bean
    public DataSource dataSource()  {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(DRIVER);
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);

        return dataSource;
    }
}
