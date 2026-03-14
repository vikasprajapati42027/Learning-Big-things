package TestJava.Test87;

import java.util.concurrent.locks.StampedLock;

class SharedCounter {
    private int count = 0;
    
    // StampedLock provides HUGE performance boosts for scenarios with many readers and few writers.
    // Unlike ReentrantReadWriteLock, it has an "Optimistic Read" mode that doesn't actually block writers!
    private final StampedLock lock = new StampedLock();

    public void writeAndIncrement() {
        // Exclusive write lock
        long stamp = lock.writeLock();
        try {
            System.out.println(Thread.currentThread().getName() + " got WRITE lock (stamp " + stamp + ")");
            count++;
            try { Thread.sleep(200); } catch (InterruptedException e) {}
        } finally {
            lock.unlockWrite(stamp);
            System.out.println(Thread.currentThread().getName() + " released WRITE lock");
        }
    }

    public void optimisticRead() {
        // 1. Try an optimistic read. This is extremely fast because it doesn't lock anything!
        long stamp = lock.tryOptimisticRead();
        
        // 2. Read the state into a local variable
        int currentCount = count;
        System.out.println(Thread.currentThread().getName() + " optimistically read: " + currentCount);
        
        try { Thread.sleep(100); } catch (InterruptedException e) {}

        // 3. Check if a Writer swooped in and changed data while we were reading
        if (!lock.validate(stamp)) {
            System.out.println(Thread.currentThread().getName() + " -> Invalid stamp! Writer interfered! Upgrading to full read lock.");
            
            // 4. If someone interfered, fall back to a traditional pessimistic read lock
            stamp = lock.readLock();
            try {
                currentCount = count; // re-read the fresh data safely
                System.out.println(Thread.currentThread().getName() + " pessimism read: " + currentCount);
            } finally {
                lock.unlockRead(stamp);
            }
        } else {
            System.out.println(Thread.currentThread().getName() + " -> Valid stamp! Optimistic read success.");
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== StampedLock (Optimistic Reading) ===\n");

        SharedCounter counter = new SharedCounter();

        Thread reader1 = new Thread(counter::optimisticRead, "Reader-1");
        Thread writer = new Thread(counter::writeAndIncrement, "Writer");
        Thread reader2 = new Thread(counter::optimisticRead, "Reader-2");

        reader1.start(); // Starts optimistic read
        Thread.sleep(10); 
        writer.start();  // Starts writing (Invalidates reader1's stamp!)
        Thread.sleep(10);
        reader2.start(); // This one will have to wait or retry

        reader1.join();
        writer.join();
        reader2.join();
    }
}
