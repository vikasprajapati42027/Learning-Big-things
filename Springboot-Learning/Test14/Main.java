package Test14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * Spring Boot uses SLF4J with Logback by default for logging.
 * Never use System.out.println in real apps!
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Component
class LoggerRunner implements CommandLineRunner {
    // Create a logger instance
    private static final Logger logger = LoggerFactory.getLogger(LoggerRunner.class);

    @Override
    public void run(String... args) {
        logger.info("This is an INFO message - standard info.");
        logger.warn("This is a WARNING message - something might be wrong.");
        logger.error("This is an ERROR message - something failed!");
        logger.debug("This is a DEBUG message - only shows if configured.");
        
        // Dynamic logging
        String name = "Vikas";
        logger.info("Greetings, {}! This is a parameterized log.", name);
    }
}
