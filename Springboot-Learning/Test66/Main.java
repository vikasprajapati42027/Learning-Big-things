package Test66;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Dead Letter Queues (DLQ):
 * Where failing messages go to "die" (be investigated).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Why a message goes to DLQ:
 * 1. Rejected (requeue = false).
 * 2. TTL (Time to Live) expired.
 * 3. Queue length limit exceeded.
 */
