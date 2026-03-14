package Test28;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Spring Events:
 * Decouple your components by communicating through messages (events).
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

// 1. Define the Event
class UserLoggedInEvent extends ApplicationEvent {
    private final String username;
    public UserLoggedInEvent(Object source, String username) {
        super(source);
        this.username = username;
    }
    public String getUsername() { return username; }
}

// 2. Publish the Event
@Component
class LoginService implements CommandLineRunner {
    private final ApplicationEventPublisher publisher;
    public LoginService(ApplicationEventPublisher publisher) { this.publisher = publisher; }

    @Override
    public void run(String... args) {
        System.out.println("LoginService: User vikas is logging in...");
        publisher.publishEvent(new UserLoggedInEvent(this, "vikas"));
    }
}

// 3. Listen to the Event
@Component
class WelcomeEmailListener {
    @EventListener
    public void onUserLogin(UserLoggedInEvent event) {
        System.out.println("WelcomeEmailListener: Sending email to " + event.getUsername());
    }
}
