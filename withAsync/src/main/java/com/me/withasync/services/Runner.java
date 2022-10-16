package com.me.withasync.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class Runner {
    public Runner(TimeService timeService){
        timeService.printTime();
        timeService.collectTime(5);
        timeService.printTime();
        timeService.printTime();
        timeService.printTime();
        log.info("--- end ---");
    }
}
