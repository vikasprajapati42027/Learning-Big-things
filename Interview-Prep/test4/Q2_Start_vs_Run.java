/**
 * Interviewer: start() vs run()?
 * Candidate: start() creates a new thread. run() just executes the method in the CURRENT thread (no parallelism).
 */
public class Q2_Start_vs_Run {
    public static void main(String[] args) {
        Thread t = new Thread(() -> System.out.println("Async"));
        t.start(); // Correct way to run a new thread
    }
}
