package com.me.withasync.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
@Log4j2
public class TimeService {
    private static final String STORE_PATH = "withAsync/src/main/resources/store/";
    private List<String> times = new ArrayList<>();

    public void printTime() {
        log.info(String.format("--- %s ---", LocalTime.now()));
    }

    @Async(value = "threadPoolTaskExecutor")
    public void collectTime(int counter) {
        do {
            counter--;
            times.add(LocalTime.now().toString());
            if (times.size() == 3) appendTimeFileToStore();
            sleep();
        } while (counter > 0);
        log.info("--- end ---");
    }

    private void appendTimeFileToStore() {
        String fileName = STORE_PATH + LocalTime.now().getNano() + ".txt";
        Path path = Path.of(fileName).toAbsolutePath();
        try {
            Files.write(path, times, CREATE, CREATE_NEW);
            times = new ArrayList<>();
            log.info(fileName + " added to store");
        } catch (IOException e) {
            log.warn(e.getMessage(), e);
        }
    }

    private void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            log.warn(e.getMessage(), e);
            Thread.currentThread().interrupt();
        }
    }
}
