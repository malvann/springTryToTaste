package com.spring.condition.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "college.smt", havingValue = "loop", matchIfMissing = true)
public class Flag2 implements FlagService{

    @Override
    public void printname() {
        System.out.println("FlagServiceImpl-2");
    }}
