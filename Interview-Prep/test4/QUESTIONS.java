/**
 * Interview Prep: Test 4 - Multithreading
 * 10 Simple Examples with Explanation
 */

// 1. Thread vs Runnable
// Extending Thread is simpler, but Implementing Runnable allows inheriting from another class.
class MyThread extends Thread { public void run() {} }
class MyTask implements Runnable { public void run() {} }

// 2. Start() vs Run()
// start() creates a NEW thread. run() executes in the SAME thread (no parallelism).
class Q2 {
    void demo() {
        Thread t = new Thread(() -> {});
        t.start(); // Correct way
    }
}

// 3. Synchronized Keyword
// Only one thread can enter the method at a time, preventing data corruption.
class Counter {
    private int count;
    public synchronized void inc() { count++; }
}

// 4. Volatile Keyword
// Ensures the variable is read from RAM, not from thread's CPU cache.
class Q4 {
    private volatile boolean flag = true;
}

// 5. Wait() and Notify()
// wait(): thread gives up lock. notify(): wakes up waiting thread.
// Used inside synchronized blocks.
class Q5 {
    synchronized void pause() throws InterruptedException { wait(); }
    synchronized void resume() { notify(); }
}

// 6. Deadlock
// Thread 1 holds A, waits for B. Thread 2 holds B, waits for A.
class Q6 { }

// 7. ExecutorService (Thread Pooling)
// Reuses threads instead of creating new ones constantly.
import java.util.concurrent.*;
class Q7 {
    void demo() {
        ExecutorService ex = Executors.newFixedThreadPool(2);
        ex.execute(() -> System.out.println("Task"));
    }
}

// 8. Callable vs Runnable
// Callable can return a value and throw checked exceptions.
class Q8 {
    Callable<Integer> task = () -> 42;
}

// 9. ThreadLocal
// Each thread gets its own private copy of the variable.
class Q9 {
    ThreadLocal<Integer> id = new ThreadLocal<>();
}

// 10. Join()
// Main thread waits until child thread finishes.
class Q10 {
    void demo() throws InterruptedException {
        Thread t = new Thread();
        t.start();
        t.join();
    }
}

public class QUESTIONS {
    public static void main(String[] args) {
        System.out.println("10 Multithreading Questions with Code Ready.");
    }
}
