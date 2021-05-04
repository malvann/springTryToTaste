package com.spring.application.beanInjection.college;

import com.spring.application.beanInjection.parts.Information;
import com.spring.application.beanInjection.parts.Principal;
import com.spring.application.beanInjection.teacher.Teacher;

public class ExtraCollege {
    private Principal principal;
    private Information information;
    private Teacher teacher;

//    Constructor injection
    public ExtraCollege(Principal principal) {
        this.principal = principal;
    }

//    Setter injection
    public void setInformation(Information information) {
        this.information = information;
    }

//    Setter injection
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void test(){
        System.out.println("Teat message. " + ExtraCollege.class.getSimpleName() + " is working.");
        principal.principalInfo();
        information.info();
        teacher.teach();
    }
}
