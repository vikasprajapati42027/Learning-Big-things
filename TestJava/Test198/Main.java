package TestJava.Test198;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 1. Target Interface (Required for JDK Dynamic Proxies)
interface PaymentService {
    void processPayment(int amount);
}

// 2. Real Implementation (Business Logic ONLY)
class PaymentServiceImpl implements PaymentService {
    @Override
    public void processPayment(int amount) {
        System.out.println("   [Business Logic] Processing payment of $" + amount);
        try { Thread.sleep(500); } catch (Exception e) {} // Simulate work
    }
}

// 3. The Aspect (Cross-Cutting Concerns: Logging, Timing, Security)
class LoggingAspect implements InvocationHandler {
    private final Object target;

    public LoggingAspect(Object target) { this.target = target; }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\n[AOP BEFORE] Method '" + method.getName() + "' is about to be called...");
        long startTime = System.currentTimeMillis();

        // Execute the ACTUAL method on the ACTUAL object
        Object result = method.invoke(target, args);

        long endTime = System.currentTimeMillis();
        System.out.println("[AOP AFTER] Method finished. Execution time: " + (endTime - startTime) + "ms");
        
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 198: Aspect-Oriented Programming (AOP) Concept ===\n");

        System.out.println("AOP allows you to separate Cross-Cutting Concerns (Logging, Metrics, Security)");
        System.out.println("from your core business logic using Proxies!\n");

        // The actual object
        PaymentService realService = new PaymentServiceImpl();

        // The Proxy created dynamically by the Framework!
        PaymentService proxyService = (PaymentService) Proxy.newProxyInstance(
                PaymentService.class.getClassLoader(),
                new Class[]{PaymentService.class},
                new LoggingAspect(realService)
        );

        // When the user uses the service, they are actually talking to the Proxy!
        System.out.println("User clicks 'Pay $50'...");
        proxyService.processPayment(50);
        
        System.out.println("\nUser clicks 'Pay $100'...");
        proxyService.processPayment(100);
    }
}
