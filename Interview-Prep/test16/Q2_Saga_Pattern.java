/**
 * INTERVIEWER: How do you handle distributed transactions in Microservices?
 * 
 * CANDIDATE: We use the Saga Pattern. Instead of a single ACID transaction, a Saga 
 * is a sequence of local transactions where each one updates a service and publishes 
 * an event.
 * 
 * PROPER EXPLANATION:
 * 1. Choreography: Each service produces and listens to events/messages. Decentralized.
 * 2. Orchestration: A central orchestrator tells the participants what local transactions to execute.
 * 3. Compensating Transactions: If a step fails, the Saga executes undo operations for previous steps.
 */

public class Q2_Saga_Pattern {
    public static void main(String[] args) {
        System.out.println("Saga Workflow:");
        System.out.println("1. Order Svc: Create Order (Pending)");
        System.out.println("2. Payment Svc: Execute Payment (Success)");
        System.out.println("3. Inventory Svc: Update Stock (Failed)");
        System.out.println("4. Compensating Action: Payment Svc (Refund)");
        System.out.println("5. Compensating Action: Order Svc (Cancel)");
    }
}
