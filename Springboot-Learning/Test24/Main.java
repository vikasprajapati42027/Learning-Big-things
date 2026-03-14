package Test24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Scheduled Tasks:
 * Running code at specific intervals or times.
 */
@SpringBootApplication
@EnableScheduling
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Component
class TaskScheduler {

    // Runs every 5 seconds (5000ms)
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("Fixed Rate Task: Checking system status...");
    }

    // Cron expression: Seconds Minutes Hours DayOfMonth Month DayOfWeek
    // Runs at the 0th second of every minute
    @Scheduled(cron = "0 * * * * *")
    public void runEveryMinute() {
        System.out.println("Cron Task: Generating summary report...");
    }
}
