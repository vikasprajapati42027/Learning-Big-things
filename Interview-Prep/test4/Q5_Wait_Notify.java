/**
 * Interviewer: wait() vs notify()?
 * Candidate: Used for Inter-Thread Communication. 
 * wait() pauses thread and releases lock. notify() wakes it up.
 */
public class Q5_Wait_Notify {
    synchronized void step1() throws InterruptedException { wait(); }
    synchronized void step2() { notify(); }
}
