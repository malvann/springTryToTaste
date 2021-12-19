package com.spring.condition.model;

import com.spring.condition.service.FlagService;
import com.spring.condition.service.FooService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ServiceHolder {
    private FooService fooService;
    private FlagService flagService;

    public void display() {
        System.out.println(this);
        fooService.printFlag();
        flagService.printname();
    }
}
