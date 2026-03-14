package Test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

/**
 * Layered Architecture Flow:
 * Main -> Service -> Repository
 */
@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
        System.out.println("Starting Test3: Layered Architecture...");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("App is running. Fetching processed users...");
        
        List<String> users = userService.getProcessedUserNames();
        System.out.println("Users from Service: " + users);
    }
}
