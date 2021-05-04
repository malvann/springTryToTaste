package com.spring.aop.withXML.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundMethodAdvice implements MethodInterceptor {
    private static final String CLASS_NAME = AroundMethodAdvice.class.getSimpleName();
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("Method name: " + methodInvocation.getMethod().getName()
        + "\nMethod args: " + methodInvocation.getArguments()
        + "\n" + CLASS_NAME + ": before.");

        try {
            Object result = methodInvocation.proceed();
            System.out.println(CLASS_NAME + ": after.");
            return result;
        } catch (IllegalArgumentException e){
            e.printStackTrace();
            throw e;
        }
    }
}
