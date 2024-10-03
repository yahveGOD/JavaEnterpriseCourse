package org.example.main.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import({HibernateConfig.class, LiquibaseConfig.class,ObjectMapperConfig.class})
@ComponentScan("org.example")
public class AppConfig {
}
