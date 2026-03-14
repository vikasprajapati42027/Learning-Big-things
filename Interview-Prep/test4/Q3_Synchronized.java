/**
 * Interviewer: What is synchronized?
 * Candidate: It ensures only one thread can access a block/method at a time, preventing Data Race.
 */
class Counter {
    private int count = 0;
    public synchronized void inc() { count++; }
}
public class Q3_Synchronized { }
