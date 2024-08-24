package com.me.withasync.services;

import lombok.extern.java.Log;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log
@Component
public class ScheduleAsyncJob {

    @Async("taskExecutor")
    @Scheduled(cron = "0 0 12 * * ?")
    public void generateDailyReport() {
        log.info("Starting daily report generation...");
        try {
            // Report generation logic
            log.info("Daily report generated successfully.");
        } catch (Exception e) {
            log.warning("Error generating daily report: %s".formatted(e.getMessage()));
        }
    }

    @Async("taskExecutor")
    @Scheduled(cron = "0 0 1 * * ?")
    public void performCleanup() {
        // Cleanup logic
    }
}
