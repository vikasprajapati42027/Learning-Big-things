/**
 * Interviewer: What are thread states?
 * Candidate: New, Runnable, Blocked, Waiting, Timed Waiting, Terminated.
 */
public class Q1_Thread_Lifecycle {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {});
        System.out.println(t.getState()); // NEW
    }
}
