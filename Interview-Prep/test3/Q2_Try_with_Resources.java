/**
 * Interviewer: Why use try-with-resources?
 * Candidate: It automatically closes resources (like files/DB connections) to prevent memory leaks.
 */
import java.io.*;
public class Q2_Try_with_Resources {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            // Processing...
        } catch (IOException e) { }
    }
}
