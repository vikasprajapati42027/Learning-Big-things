/**
 * Interviewer: Why use ExecutorService?
 * Candidate: It manages a POOL of threads. Reusing threads is more efficient than creating new ones for every task.
 */
import java.util.concurrent.*;
public class Q7_ExecutorService {
    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(() -> System.out.println("Pooled Thread"));
    }
}
