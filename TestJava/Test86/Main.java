package TestJava.Test86;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Buffer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 3;
    
    // The Lock replaces the 'synchronized' keyword
    private Lock lock = new ReentrantLock();
    
    // Conditions replace wait() and notifyAll(). 
    // They are bound to a specific lock!
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    public void produce(int item) throws InterruptedException {
        lock.lock(); // Explicitly acquire the lock
        try {
            while (queue.size() == CAPACITY) {
                System.out.println("Buffer is full. Producer waiting...");
                notFull.await(); // Gives up the lock and waits here
            }
            queue.offer(item);
            System.out.println("Produced: " + item + " | Buffer: " + queue);
            notEmpty.signalAll(); // Wake up consumers waiting on the notEmpty condition
        } finally {
            lock.unlock(); // Always unlock in a finally block!
        }
    }

    public void consume() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                System.out.println("Buffer is empty. Consumer waiting...");
                notEmpty.await();
            }
            int item = queue.poll();
            System.out.println("Consumed: " + item + " | Buffer: " + queue);
            notFull.signalAll(); // Wake up producers waiting on the notFull condition
        } finally {
            lock.unlock();
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== ReentrantLock & Condition Variables ===\n");

        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {}
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(250); // Consumer is slower
                }
            } catch (InterruptedException e) {}
        });

        consumer.start();
        Thread.sleep(50); // Let consumer start first to hit the empty buffer
        producer.start();

        producer.join();
        consumer.join();
    }
}
