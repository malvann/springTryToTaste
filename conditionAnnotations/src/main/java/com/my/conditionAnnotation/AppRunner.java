package com.my.conditionAnnotation;

import com.my.conditionAnnotation.service.CopyService;
import com.my.conditionAnnotation.service.PrintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

@Slf4j
@SpringBootApplication
@PropertySource("classpath:app.properties")
public class AppRunner {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(AppRunner.class, args);
        context.getBean(PrintService.class).printMessage();
        log.info("Copies number: {}", context.getBean(CopyService.class).getNumOfCopies());
    }
}
