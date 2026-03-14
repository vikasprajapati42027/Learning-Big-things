package Test32;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * AOP (Aspect Oriented Programming):
 * Separating cross-cutting concerns (logging, security) 
 * from business logic.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

@Aspect
@Component
class LoggingAspect {
    // Run this code BEFORE any method in the service package
    @Before("execution(* Test32.BusinessService.*(..))")
    public void logBefore() {
        System.out.println("AOP Aspect: Method is about to start...");
    }
}

@Component
class BusinessService {
    public void processPayment() {
        System.out.println("BusinessService: Processing payment logic.");
    }
}

@Component
class AopRunner implements CommandLineRunner {
    private final BusinessService service;
    public AopRunner(BusinessService service) { this.service = service; }
    @Override
    public void run(String... args) {
        service.processPayment();
    }
}
