package com.my.conditionAnnotation.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@ConditionalOnProperty(value = "service.flag", havingValue = "hoo", matchIfMissing = true)
public class HooPrintService implements PrintService {
    @Override
    public void printMessage() {
        log.info("Message: {}", HooPrintService.class);
    }
}
