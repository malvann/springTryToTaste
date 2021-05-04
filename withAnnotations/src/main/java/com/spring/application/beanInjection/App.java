package com.spring.application.beanInjection;

import com.spring.application.beanInjection.college.ExtraCollege;
import com.spring.application.componentInjection.CollegeConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
        ExtraCollege extraCollege = context.getBean(ExtraCollege.class);
//        ExtraCollege extraCollege = context.getBean("colBean", ExtraCollege.class);
        System.out.println("BEAN CREATED: " + extraCollege.getClass().getSimpleName() + ": " + extraCollege);
        extraCollege.test();
    }
}
