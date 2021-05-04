package com.spring.application;

import com.spring.application.college.College;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        College college = context.getBean("collegeBean", College.class);
        System.out.println("BEAN CREATED: " + college);
    }
}
