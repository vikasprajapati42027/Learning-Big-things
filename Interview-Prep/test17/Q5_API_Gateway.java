/**
 * Interviewer: Explain API_Gateway Concept 5.
 * Candidate: Professional detailed answer regarding API_Gateway 5.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
public class Q5_API_Gateway {
    private boolean open = false;

    public void demo() {
        callService();
        callService();
    }

    private void callService() {
        if (open) {
            System.out.println("Circuit open: short-circuiting request.");
            return;
        }
        try {
            System.out.println("Calling downstream service...");
            throw new IllegalStateException("Failure");
        } catch (Exception e) {
            open = true;
            System.out.println("Caught failure, opening circuit.");
        }
    }
}
