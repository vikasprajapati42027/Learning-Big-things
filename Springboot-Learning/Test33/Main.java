package Test33;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * Advanced AOP: @Around
 * You can control the execution of the method!
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
class PerformanceAspect {
    @Around("execution(* Test33.SlowService.*(..))")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        
        // Execute the actual method
        Object result = joinPoint.proceed();
        
        long duration = System.currentTimeMillis() - start;
        System.out.println("AOP: Method " + joinPoint.getSignature().getName() + " took " + duration + "ms");
        
        return result;
    }
}

@Component
class SlowService {
    public void heavyDBCall() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("SlowService: DB data fetched.");
    }
}

@Component
class Runner implements CommandLineRunner {
    private final SlowService service;
    public Runner(SlowService service) { this.service = service; }
    @Override
    public void run(String... args) throws Exception {
        service.heavyDBCall();
    }
}
