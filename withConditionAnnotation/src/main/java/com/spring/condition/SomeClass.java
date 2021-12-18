package com.spring.condition;

import com.spring.condition.service.FlagService;
import com.spring.condition.service.FooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeClass {
    @Autowired
    private FooService fooService;

    @Autowired
    private FlagService flagService;

    public void display(){
        System.out.println(this);
        fooService.printFlag();
        flagService.printname();
    }
}
