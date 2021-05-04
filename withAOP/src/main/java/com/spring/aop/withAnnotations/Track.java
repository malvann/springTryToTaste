package com.spring.aop.withAnnotations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Track {
    @Pointcut("execution(* Operation.m*(..))")
    public void k(){} //pointcut name

    @Before("k()")
    public void advice(JoinPoint jp){
        System.out.println("ADDITIONAL CONCERN.");
    }
}
