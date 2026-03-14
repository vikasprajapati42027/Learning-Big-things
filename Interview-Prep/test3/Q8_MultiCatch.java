/**
 * Interviewer: What is Multi-Catch?
 * Candidate: Handling multiple exceptions in a single catch block using | (Java 7+).
 */
public class Q8_MultiCatch {
    void demo() {
        try { }
        catch(ArithmeticException | NullPointerException e) { }
    }
}
