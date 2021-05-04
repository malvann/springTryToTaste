package com.spring.application.college;

import com.spring.application.parts.InfoMessage;
import org.springframework.stereotype.Component;

@Component("collegeBean")
public class College {
    private static final String initMSG = "-- College Initialised --";
    private static final String destrMSG = "-- College Destroyed --";
    private String name;
    private String address;

    private InfoMessage infoMessage;

//    Constructor injection
    public College(InfoMessage infoMessage) {
        this.infoMessage = infoMessage;
    }

//    Setter injection
    public void setName(String name) {
        this.name = name;
    }

//    Setter injection
    public void setAddress(String address) {
        this.address = address;
    }

    public void test(){
        infoMessage.test();
    }

    @Override
    public String toString() {
        return "College{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
//                ", teacher1=" + teacher1 +
//                ", teacher2=" + teacher2 +
                ", infoMessage=" + infoMessage +
                '}';
    }

    public void collegeInit(){
        System.out.println(initMSG);
    }

    public void collegeDestroy(){
        System.out.println(destrMSG);
    }
}
