package Test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunner is a Spring Boot interface used to run code after 
 * the application context is fully loaded.
 */
@Component
public class AppRunner implements CommandLineRunner {

    /**
     * @Autowired tells Spring to "inject" the GreetingService bean here.
     * This is Dependency Injection (DI). We didn't use the 'new' keyword!
     */
    @Autowired
    private GreetingService greetingService;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("AppRunner is running...");
        
        // Using the injected bean
        String message = greetingService.getGreeting();
        System.out.println("Service Message: " + message);
    }
}
