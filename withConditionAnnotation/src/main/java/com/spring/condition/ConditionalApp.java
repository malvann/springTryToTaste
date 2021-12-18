package com.spring.condition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConditionalApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ConditionalApp.class, args);
        SomeClass someClass = context.getBean(SomeClass.class);
        someClass.display();
    }
}
