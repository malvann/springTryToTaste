package com.spring.ripper;

import com.spring.ripper.quoter.Quoter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Configurations.class);
        context.getBean(Quoter.class).sayQuoter();
    }
}
