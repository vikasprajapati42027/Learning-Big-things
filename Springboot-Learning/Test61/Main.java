package Test61;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot with gRPC:
 * A high-performance RPC framework initially developed by Google.
 * Uses HTTP/2 for transport and Protocol Buffers for message format.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * gRPC vs REST:
 * 1. Performance: Binary (smaller) vs Text (larger JSON).
 * 2. Strict Contract: Defined in .proto files.
 * 3. Streaming: Supports Bi-directional streaming out of the box.
 * 4. Language Neutral: Easy to connect Java, Go, Python, etc.
 */
