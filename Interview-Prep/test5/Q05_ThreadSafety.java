import java.util.concurrent.*;
import java.util.concurrent.locks.*;

// Q5: Thread Safety Approaches
public class Q05_ThreadSafety {

    // Approach 1: synchronized method
    private int counter1 = 0;
    public synchronized void incrementSync() { counter1++; }

    // Approach 2: ReentrantLock (more flexible)
    private int counter2 = 0;
    private final ReentrantLock lock = new ReentrantLock();
    public void incrementLock() {
        lock.lock();
        try { counter2++; }
        finally { lock.unlock(); } // Always release in finally!
    }

    // Approach 3: Atomic (fastest, lock-free)
    private final java.util.concurrent.atomic.AtomicInteger counter3 = new java.util.concurrent.atomic.AtomicInteger(0);
    public int incrementAtomic() { return counter3.incrementAndGet(); }

    // Approach 4: ReadWriteLock (allow concurrent reads, exclusive writes)
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private String data = "initial";

    public String readData() {
        rwLock.readLock().lock(); // Multiple threads can hold this simultaneously
        try { return data; }
        finally { rwLock.readLock().unlock(); }
    }
    public void writeData(String s) {
        rwLock.writeLock().lock(); // Exclusive — all readers must wait
        try { data = s; }
        finally { rwLock.writeLock().unlock(); }
    }
}
