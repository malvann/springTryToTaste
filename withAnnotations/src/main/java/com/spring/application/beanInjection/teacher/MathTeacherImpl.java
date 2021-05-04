package com.spring.application.beanInjection.teacher;

public class MathTeacherImpl implements Teacher{
    @Override
    public void teach() {
        System.out.println("LET'S STUDY MATH!\nMATH! MATH! MATH!");
    }
}
