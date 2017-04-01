package com.pleshchenko.sbb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@Import({JpaConfig.class})
@EnableWebMvc
@ComponentScan("com.pleshchenko.sbb")
public class AppConfig {

}
