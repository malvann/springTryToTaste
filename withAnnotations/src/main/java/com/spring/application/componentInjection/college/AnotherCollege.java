package com.spring.application.componentInjection.college;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

@Component
public class AnotherCollege {

    public void test(){
        System.out.println("Test message. " + AnotherCollege.class.getSimpleName() + " is working.");
    }
}
