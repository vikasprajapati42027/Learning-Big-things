package TestJava.Test48;

/**
 * Sealed Classes (Java 15 Preview, Java 17 Standard)
 * 
 * Before Sealed Classes: Either a class could be extended by ANYONE (public), 
 * or NO ONE (final).
 * 
 * Sealed Classes allow you to strictly define EXACTLY which subclasses are permitted.
 * This ensures your core domain models aren't hijacked by unknown subclasses!
 */
sealed class Result permits Success, Error {
    // This is the parent class. Only 'Success' and 'Error' are allowed to extend it.
}

// A permitted subclass MUST specify whether it is final, sealed, or non-sealed.
final class Success extends Result {
    private String data;
    
    public Success(String data) {
        this.data = data;
    }
    public String getData() { return data; }
}

final class Error extends Result {
    private String errorMessage;
    
    public Error(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() { return errorMessage; }
}

// ERROR: This class is NOT permitted by 'Result' to extend it!
// class Warning extends Result {}

class Main {
    public static void main(String[] args) {
        System.out.println("=== Sealed Classes (Java 15+) ===");

        Result result1 = new Success("User Data Loaded 100%");
        Result result2 = new Error("Database Connection Failed.");

        // Sealed classes work perfectly with Java 16+ Pattern Matching on Switch/If!
        processResult(result1);
        processResult(result2);
    }

    private static void processResult(Result res) {
        // Because 'Result' is sealed, the compiler knows ONLY Success and Error are possible.
        // It provides exhaustive checking if used in a modern switch expression.
        if (res instanceof Success s) {
            System.out.println("Success! Data: " + s.getData());
        } else if (res instanceof Error e) {
            System.out.println("Failure! Reason: " + e.getErrorMessage());
        }
    }
}
