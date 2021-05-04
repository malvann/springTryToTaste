package com.spring.application.componentInjection;

import com.spring.application.componentInjection.college.AnotherCollege;
import com.spring.application.componentInjection.college.College;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CollegeConfig.class);
        College college = context.getBean("cBean", College.class);
        System.out.println("BEAN CREATED: " + college.getClass().getSimpleName() + ": " + college);
        college.test();

        AnotherCollege anotherCollege = context.getBean(AnotherCollege.class);
        System.out.println("BEAN CREATED: " + anotherCollege.getClass().getSimpleName() + ": " + anotherCollege);
        anotherCollege.test();
    }
}
