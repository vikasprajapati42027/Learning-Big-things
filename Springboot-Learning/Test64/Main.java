package Test64;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Apache Pulsar:
 * Next-generation distributed messaging and streaming platform.
 * It combines the best of Kafka and RabbitMQ.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Features:
 * 1. Multi-tenancy native.
 * 2. Geo-replication.
 * 3. Tiered storage (Offloads old data to S3).
 * 4. Pulsar Functions (Serverless inside the broker).
 */
