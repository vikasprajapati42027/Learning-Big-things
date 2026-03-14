package com.example.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    // Runs every 5 seconds
    @Scheduled(fixedRate = 5000)
    public void heartbeat() {
        System.out.println("[SCHEDULER] Heartbeat at: " + LocalDateTime.now());
    }

    // Runs every day at midnight (Cron expression)
    @Scheduled(cron = "0 0 0 * * ?")
    public void dailyReport() {
        System.out.println("[SCHEDULER] Generating daily report...");
    }

    // Runs 10 seconds after previous run finishes (not starts)
    @Scheduled(fixedDelay = 10000)
    public void cleanupTask() {
        System.out.println("[SCHEDULER] Running cleanup task");
    }
}
