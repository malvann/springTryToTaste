package com.spring.aop.withXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        SomeService service = context.getBean("someService", SomeService.class);
        service.printName();
        System.out.println("----------------------------------");
        service.printUrl();
        try{
            service.throwException();
        } catch (Exception e) {}
        ((ClassPathXmlApplicationContext) context).close();
    }
}
