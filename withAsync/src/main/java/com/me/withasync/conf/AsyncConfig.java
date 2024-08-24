package com.me.withasync.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@EnableAsync
@Configuration
public class AsyncConfig {

    @Bean
    public Executor threadPoolTaskExecutor() {
        return new ThreadPoolTaskExecutor();
    }

    @Bean(name = "taskExecutor")
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);        // Minimum number of active threads
        executor.setMaxPoolSize(20);         // Maximum number of threads
        executor.setQueueCapacity(50);       // Number of tasks that can be queued
        executor.setThreadNamePrefix("ScheduleAsyncJob-"); // Prefix for thread names
        executor.initialize();
        return executor;
    }
}
