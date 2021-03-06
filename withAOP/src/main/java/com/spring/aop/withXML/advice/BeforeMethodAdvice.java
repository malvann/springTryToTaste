package com.spring.aop.withXML.advice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeMethodAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(BeforeMethodAdvice.class.getSimpleName() + ": Before method run.");
    }
}
