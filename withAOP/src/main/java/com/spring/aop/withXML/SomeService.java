package com.spring.aop.withXML;

public class SomeService {
    private String name;
    private String url;

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printName(){
        System.out.println("Name: " + name);
    }

    public void printUrl(){
        System.out.println("URL: " + url);
    }

    public void throwException() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}
