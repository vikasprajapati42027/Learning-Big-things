package Test51;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Batch:
 * Used for processing large amounts of data (millions of records).
 * It handles restarts, logging, and transaction management automatically.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Starting Test 51: Spring Batch Intro...");
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Basic components of a Batch Job:
 * 1. Job: The entire process.
 * 2. Step: A phase of the job (e.g., Read, then Process, then Write).
 * 3. ItemReader: Reads data (from DB, File, API).
 * 4. ItemProcessor: Transforms data.
 * 5. ItemWriter: Saves data.
 */
