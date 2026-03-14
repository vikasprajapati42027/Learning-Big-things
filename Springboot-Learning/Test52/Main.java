package Test52;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Batch: Chunk Processing.
 * Instead of reading 1000 items into memory, we read 10, process 10, write 10.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Simulated Step Configuration:
 * 
 * return stepBuilderFactory.get("step1")
 *     .<String, String>chunk(10) // Commit every 10 items
 *     .reader(new MyFileReader())
 *     .processor(new MyDataTransformer())
 *     .writer(new MyDbWriter())
 *     .build();
 */
