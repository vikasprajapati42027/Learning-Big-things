package Test11;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Profiles allow you to separate parts of your application configuration 
 * and make it only available in certain environments (dev, prod, test).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // You can set the profile here or via application.properties
        // System.setProperty("spring.profiles.active", "dev");
        SpringApplication.run(Main.class, args);
    }
}

interface EnvService {
    String getMessage();
}

@Component
@Profile("dev")
class DevService implements EnvService {
    @Override
    public String getMessage() { return "Running in DEVELOPMENT mode"; }
}

@Component
@Profile("prod")
class ProdService implements EnvService {
    @Override
    public String getMessage() { return "Running in PRODUCTION mode"; }
}

@Component
class Runner implements CommandLineRunner {
    private final EnvService envService;

    // Spring will inject the bean that matches the active profile
    public Runner(EnvService envService) {
        this.envService = envService;
    }

    @Override
    public void run(String... args) {
        System.out.println("Profile Test: " + envService.getMessage());
    }
}
