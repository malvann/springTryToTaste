package com.spring.application.componentInjection.teacher;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ChemistryTeacherImpl implements Teacher{
    @Override
    public void teach() {
        System.out.printf("BO-O-OM!\n");
    }
}
