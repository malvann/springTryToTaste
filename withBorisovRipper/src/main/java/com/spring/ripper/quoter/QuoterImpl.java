package com.spring.ripper.quoter;

import com.spring.ripper.annotation.InjectRandomInt;
import com.spring.ripper.annotation.PostProxy;
import com.spring.ripper.annotation.Profiling;
import lombok.Setter;

import javax.annotation.PostConstruct;

@Setter
@Profiling
public class QuoterImpl implements Quoter {
    @InjectRandomInt(min=2, max=7)
    private int repeat;
    private String message;

    @PostConstruct
    public void init(){
        System.out.println("Phase 2");
        System.out.println("Repeat: " + repeat);
    }

    public QuoterImpl() {
        System.out.println("Phase 1");
    }

    @Override
    @PostProxy
    public void sayQuoter() {
        for (int i = 0; i<repeat; i++) System.out.println("Message: " + message);
    }
}
