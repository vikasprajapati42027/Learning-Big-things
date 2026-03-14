/**
 * INTERVIEWER: Why is try-with-resources preferred over try-finally for closing resources?
 * 
 * CANDIDATE: Before Java 7, we had to manually close resources in a finally block, which led 
 * to verbose code and hidden exceptions. Try-with-resources handles it automatically.
 * 
 * PROPER EXPLANATION:
 * 1. AutoCloseable Interface: Any class implementing this can be used in try-with-resources.
 * 2. Automatic Closure: The 'close()' method is called automatically, even if an exception occurs.
 * 3. Suppressed Exceptions: If both the try block and close() throw exceptions, the 
 *    close() exception is "suppressed," so the primary exception isn't lost.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Q2_TryWithResources {
    public static void main(String[] args) {
        String path = "notes.txt";

        // OLD WAY (Verbose, leak-prone)
        BufferedReader brOld = null;
        try {
            brOld = new BufferedReader(new FileReader(path));
        } catch (IOException e) {
        } finally {
            try { if (brOld != null) brOld.close(); } catch (IOException ex) { }
        }

        // MODERN WAY (Clean, safe)
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println("Reading resource safely...");
        } catch (IOException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
