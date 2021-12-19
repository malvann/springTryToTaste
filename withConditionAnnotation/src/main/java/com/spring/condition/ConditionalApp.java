package com.spring.condition;

import com.spring.condition.model.ServiceHolder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:extra.properties")
public class ConditionalApp{
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalApp.class).run(args);
        ServiceHolder someClass = context.getBean(ServiceHolder.class);
        someClass.display();
    }
}
