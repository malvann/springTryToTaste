package com.spring.application.componentInjection;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.spring.application.componentInjection")
@PropertySource("classpath:college/college-info.properties")
public class CollegeConfig {
}
