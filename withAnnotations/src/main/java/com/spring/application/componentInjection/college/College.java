package com.spring.application.componentInjection.college;

import com.spring.application.componentInjection.parts.Principal;
import com.spring.application.componentInjection.teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("cBean")//If u didn't mention a name, it'll be created automatically from the class simple name is lower case.
public class College {
    @Value("+ 000 000 00")
    private String collegePhone;
    @Value("${college.Name}")
    private String collegeName;
    @Value("${college.Address}")
    private String collegeAddress;
    private String collegeStatus;

    @Autowired //It's better to use setter or constructor
    private Principal principal;
    @Autowired //It's better to use setter or constructor
    private Teacher teacher1;

    @Autowired //It's better to use setter or constructor
    @Qualifier("literatureTeacherImpl")
    private Teacher teacher2;

    @Required
    @Value("${college.Status}")
    public void setCollegeStatus(String collegeStatus) {
        this.collegeStatus = collegeStatus;
    }

    public void test(){
        System.out.println("Test message. " + College.class.getSimpleName() + " is working.");
        System.out.println("College phone: " + collegePhone
        + "\nCollege name: " + collegeName
        + "\nCollege address: " + collegeAddress
        + "\nCollege status: " + collegeStatus);
        principal.principalInfo();
        teacher1.teach();
        teacher2.teach();
    }
}
