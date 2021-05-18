package com.spring.application;

import com.spring.application.college.College;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
//        U can also use BeanFactory that has less features (f.e. enterprise-specific) & use less memory.
//        & factory always create bean when u create it. Context always create singleton beans when u up context
//        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        College college = context.getBean("collegeBean", College.class);
        System.out.println("BEAN CREATED: " + college );
        college.test();

//        When u close context, all beans are destroyed.
        ((ClassPathXmlApplicationContext) context).close();
    }
}
