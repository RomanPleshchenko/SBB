package com.pleshchenko.sbb.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
@Import({JpaConfig.class})
@ComponentScan("com.pleshchenko.sbb.app")
public class AppConfig {

}
