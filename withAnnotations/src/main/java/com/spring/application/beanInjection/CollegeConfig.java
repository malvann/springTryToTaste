package com.spring.application.beanInjection;

import com.spring.application.beanInjection.college.ExtraCollege;
import com.spring.application.beanInjection.parts.Information;
import com.spring.application.beanInjection.parts.Principal;
import com.spring.application.beanInjection.teacher.MathTeacherImpl;
import com.spring.application.beanInjection.teacher.Teacher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CollegeConfig {
//    Constructor injection
    @Bean
    public Principal principalBean(){
        return new Principal();
    }

//    Setter injection
    @Bean
    public Information infoBean(){
        return new Information();
    }

//    Setter injection
    @Bean
    public Teacher mathTeacherBean(){
        return new MathTeacherImpl();
    }

    @Bean(name = {"colBean", "college"})
    public ExtraCollege collegeBean(){
        ExtraCollege college =  new ExtraCollege(principalBean()); // Constructor injection
        college.setInformation(infoBean()); // Setter injection
        college.setTeacher(mathTeacherBean()); // Setter injection
        return college;
    }
}
