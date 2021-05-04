package com.spring.aop.withAnnotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Operation operation(){
        return new Operation();
    }

    @Bean
    public Track track(){
        return new Track();
    }
}
