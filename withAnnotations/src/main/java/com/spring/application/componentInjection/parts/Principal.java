package com.spring.application.componentInjection.parts;

import org.springframework.stereotype.Component;

@Component
public class Principal {
    public void principalInfo(){
        System.out.println("Hi, I am your principal.\nMy name is John Doe.");
    }
}
