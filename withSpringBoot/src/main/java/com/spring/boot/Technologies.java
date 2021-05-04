package com.spring.boot;

import org.springframework.stereotype.Component;

@Component
public class Technologies {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void tech(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Technologies{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
