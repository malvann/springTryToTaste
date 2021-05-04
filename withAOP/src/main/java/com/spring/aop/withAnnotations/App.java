package com.spring.aop.withAnnotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Operation operation = context.getBean(Operation.class);
        System.out.println("...calling msg()...");
        operation.msg();
        System.out.println("...calling m()...");
        operation.m();
        System.out.println("...calling k()...");
        operation.k();
    }
}
