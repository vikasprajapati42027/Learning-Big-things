package TestJava.Test42;

import java.util.concurrent.locks.ReentrantReadWriteLock;

// Imagine a Cache where 100 threads want to READ data, but only 1 thread occasionally WRITES data.
// Using `synchronized` would lock EVERYONE out, even other readers!
// ReentrantReadWriteLock allows MULTIPLE threads to read simultaneously, but gives EXCLUSIVE access for writing.
class SharedCache {
    private String data = "Initial Data";
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void readData(String threadName) {
        lock.readLock().lock(); // Multiple threads can hold this lock at the same time!
        try {
            System.out.println(threadName + " is reading: " + data);
            Thread.sleep(100); // Simulate slow read
        } catch (InterruptedException e) {} 
        finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String newData, String threadName) {
        lock.writeLock().lock(); // Only ONE thread can hold this lock. Read locks are blocked until this finishes.
        try {
            System.out.println(threadName + " is WRITING: " + newData);
            this.data = newData;
            Thread.sleep(200); // Simulate slow write
        } catch (InterruptedException e) {} 
        finally {
            lock.writeLock().unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ReentrantReadWriteLock Tutorial ===");
        
        SharedCache cache = new SharedCache();

        // Let's create 3 Readers and 1 Writer
        Thread reader1 = new Thread(() -> cache.readData("Reader-1"));
        Thread reader2 = new Thread(() -> cache.readData("Reader-2"));
        Thread reader3 = new Thread(() -> cache.readData("Reader-3"));
        
        Thread writer = new Thread(() -> cache.writeData("UPDATED DATA", "Writer-1"));

        // Readers start simultaneously and don't block each other
        reader1.start();
        reader2.start();
        
        // Writer starts. It must WAIT for Readers 1 & 2 to finish. 
        // Once it starts, it blocks Reader 3.
        writer.start(); 
        reader3.start();
    }
}
