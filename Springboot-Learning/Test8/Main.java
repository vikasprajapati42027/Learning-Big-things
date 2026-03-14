package Test8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        System.out.println("Starting Test 8: Data Persistence...");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Saving Users to 'Database' ---");
        userRepository.save(new User("Vikas", "vikas@example.com"));
        userRepository.save(new User("Deepmind", "ai@example.com"));

        System.out.println("\n--- Fetching All Users ---");
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        System.out.println("\n--- Finding User by ID ---");
        userRepository.findById(1L).ifPresent(user -> 
            System.out.println("Found User: " + user.getName())
        );
    }
}
