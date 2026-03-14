package TestJava.Test168;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

// A highly simplified Mock of HikariCP / Apache DBCP2
class MiniConnectionPool {
    private BlockingQueue<String> pool; // We use Strings instead of java.sql.Connection for the mock!

    public MiniConnectionPool(int poolSize) {
        pool = new ArrayBlockingQueue<>(poolSize);
        // Pre-warm the pool by initializing 5 heavy connections at startup!
        for (int i = 1; i <= poolSize; i++) {
            pool.offer("Database-Connection-" + i);
        }
        System.out.println("Pool Initialized with " + poolSize + " connections.\n");
    }

    // Getting a connection just takes it out of the queue
    public String getConnection() throws InterruptedException {
        // Wait at most 2 seconds for a connection to become available
        String conn = pool.poll(2, TimeUnit.SECONDS);
        if (conn == null) {
            throw new RuntimeException("Connection Timeout! Too many users accessing the DB.");
        }
        return conn;
    }

    // Closing a connection doesn't destroy it. It just puts it BACK into the queue!
    public void releaseConnection(String conn) {
        pool.offer(conn);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Test 168: Connection Pooling Concept ===\n");

        System.out.println("Creating a raw Database Connection takes ~100ms (TCP Handshake, Auth, etc).");
        System.out.println("If 1000 users hit your site, doing that 1000 times will crash your DB.");
        System.out.println("Connection Pooling keeps a 'pool' of already-open connections ready to use!\n");

        MiniConnectionPool cp = new MiniConnectionPool(2); // Only 2 connections allowed!

        // User 1
        String conn1 = cp.getConnection();  
        System.out.println("User 1 acquired: " + conn1);

        // User 2
        String conn2 = cp.getConnection();  
        System.out.println("User 2 acquired: " + conn2);

        // User 3 (Should fail because the pool is empty!)
        try {
            System.out.println("User 3 waiting for a connection...");
            String conn3 = cp.getConnection(); // Blocks for 2 seconds, then throws exception
            System.out.println("User 3 acquired: " + conn3);
        } catch (Exception e) {
            System.out.println("User 3 Error: " + e.getMessage());
        }

        System.out.println("\nUser 1 finishes processing and releases the connection...");
        cp.releaseConnection(conn1);

        // User 4
        String conn4 = cp.getConnection();  
        System.out.println("User 4 instantly acquired: " + conn4);
    }
}
