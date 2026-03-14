// Q3: Exception Handling Best Practices
public class Q03_Exceptions {

    // 1. Always use specific exceptions over the generic Exception
    public static void readFile(String path) throws java.io.IOException {
        java.nio.file.Files.readAllLines(java.nio.file.Path.of(path));
    }

    // 2. try-with-resources — auto-closes resources (Java 7+)
    public static String readData() throws Exception {
        try (var stream = new java.io.FileInputStream("data.txt")) {
            return new String(stream.readAllBytes());
        } // stream.close() called automatically, even if exception!
    }

    // 3. Custom Exception with context
    static class PaymentFailedException extends RuntimeException {
        private final String orderId;
        public PaymentFailedException(String orderId, String reason) {
            super("Payment failed for order " + orderId + ": " + reason);
            this.orderId = orderId;
        }
        public String getOrderId() { return orderId; }
    }

    // 4. Chain exceptions — don't lose the original cause!
    public static void processPayment(String orderId) {
        try {
            callPaymentApi(orderId);
        } catch (Exception e) {
            throw new PaymentFailedException(orderId, e.getMessage()); // wrap, not swallow
        }
    }

    static void callPaymentApi(String id) throws Exception {
        throw new Exception("Connection timeout");
    }
}
