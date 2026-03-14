package Test23;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Async Execution:
 * Allows you to run methods in a separate thread.
 */
@SpringBootApplication
@EnableAsync
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Service
class EmailService {
    @Async
    public void sendEmail() throws InterruptedException {
        System.out.println("Async thread: Starting email send...");
        Thread.sleep(3000); // Simulate slow work
        System.out.println("Async thread: Email sent!");
    }
}

@Component
class AsyncRunner implements CommandLineRunner {
    private final EmailService emailService;

    public AsyncRunner(EmailService emailService) {
        this.emailService = emailService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Main thread: Triggering email...");
        emailService.sendEmail();
        System.out.println("Main thread: Continuing execution immediately!");
    }
}
