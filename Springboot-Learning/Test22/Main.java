package Test22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot DevTools:
 * A module that aims to make development time a bit more pleasant.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * Features:
 * 1. Automatic Restart: App restarts when a file on the classpath changes.
 * 2. LiveReload: Browser refreshes when a resource (HTML/CSS) changes.
 * 3. Configurations: Disables template caching by default (for Thymeleaf).
 * 4. H2 Console: Enabled by default if H2 is present.
 */
