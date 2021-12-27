package com.my.conditionAnnotation.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(value = "service.copy", havingValue = "one")
public class OneCopyService implements CopyService{
    @Override
    public String getNumOfCopies() {
        return String.valueOf(1);
    }
}
