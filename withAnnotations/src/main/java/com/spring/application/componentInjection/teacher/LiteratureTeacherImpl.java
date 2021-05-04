package com.spring.application.componentInjection.teacher;

import org.springframework.stereotype.Component;

@Component
public class LiteratureTeacherImpl implements Teacher {
    @Override
    public void teach() {
        System.out.println("LET'S STUDY LITERATURE! LITERATURE! LITERATURE! LITERATURE!");
    }
}
