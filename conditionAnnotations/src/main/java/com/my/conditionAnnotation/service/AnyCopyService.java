package com.my.conditionAnnotation.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnExpression(value = "!'${service.copy}'.equals('one')")
public class AnyCopyService implements CopyService{
    @Value("${service.copy}")
    @NonNull
    private String copyNumber;

    @Override
    public String getNumOfCopies() {
        return copyNumber;
    }
}
