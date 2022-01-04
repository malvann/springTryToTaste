package com.spring.aop.withAnnotations;

public class Operation {
    public void msg(){
        System.out.println("msg method invoked.");
    }

    public int m(){
        System.out.println("m method invoker.");
        return 1;
    }

    public int k(){
        System.out.println("k method invoker.");
        return 2;
    }
}
