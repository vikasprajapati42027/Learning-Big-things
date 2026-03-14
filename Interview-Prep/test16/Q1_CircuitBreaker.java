/**
 * INTERVIEWER: What is a Circuit Breaker and why do we use Resilience4j?
 * CANDIDATE: A Circuit Breaker prevents cascading failures in microservices. 
 * It has three states: CLOSED (normal), OPEN (tripped/failing), and HALF_OPEN (probing).
 */
class PaymentServiceProxy {
    boolean isOpen = false;

    public void callPayment() {
        if (isOpen) {
            System.out.println("Circuit is OPEN: Falling back to cached response.");
            return;
        }
        try {
            System.out.println("Calling external Payment Service...");
            // Simulate failure
            throw new Exception("Timeout!");
        } catch (Exception e) {
            isOpen = true;
            System.out.println("Failure detected! Tripping Circuit to OPEN.");
        }
    }
}

public class Q1_CircuitBreaker {
    public static void main(String[] args) {
        PaymentServiceProxy service = new PaymentServiceProxy();
        service.callPayment(); // First call fails, trips circuit
        service.callPayment(); // Second call immediate fallback
    }
}
