package com.spring.condition.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "college.smt", havingValue = "foo", matchIfMissing = true)
public class FooService {
    public void printFlag(){
        System.out.println("Foo");
    }
}
