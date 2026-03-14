package Test15;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

/**
 * Unit Testing is about testing a single component in isolation.
 * Spring Boot provides @SpringBootTest for integration tests 
 * and utilities for JUnit 5.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Service
class CalculatorService {
    public int add(int a, int b) { return a + b; }
}

/**
 * In a real project, this would be in src/test/java.
 */
class CalculatorTest {
    // In a real test class, you would use:
    // @Test
    // void testAdd() { ... }
}
