/**
 * Interviewer: Explain Microservices_Architecture Concept 5.
 * Candidate: Professional detailed answer regarding Microservices_Architecture 5.
 * 
 * Key Highlights: Independence, Scaling, Polyglot, Small Services
 */
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Q5_Microservices_Architecture {
    public void demo() {
        System.out.println("Concept 5: Observability via metrics and distributed tracing.");
        AtomicInteger traceId = new AtomicInteger(1000);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 2; i++) {
            executor.submit(() -> {
                System.out.println("Trace ID: " + traceId.getAndIncrement() + " logged.");
            });
        }
        executor.shutdown();
    }
}
