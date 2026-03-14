package TestJava.Test103;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== File Locks (FileChannel.lock) ===\n");

        // FileLocks are used to coordinate access to a single file across MULTIPLE PROCESSES,
        // not just multiple threads! (e.g., Two different Java applications fighting over one file).
        
        String logFile = "TestJava/Test103/shared_log.txt";

        try (RandomAccessFile file = new RandomAccessFile(logFile, "rw");
             FileChannel channel = file.getChannel()) {

            System.out.println("Trying to acquire an Exclusive Lock on the file...");
            
            // .lock() BLOCKS until the lock is acquired.
            // .tryLock() grabs it if available, or returns null immediately.
            try (FileLock lock = channel.lock()) {
                System.out.println("Exclusive Lock acquired! No other process can write to this file right now.");
                
                System.out.println("Writing sensitive data...");
                channel.write(java.nio.ByteBuffer.wrap("System Update: All secure.\n".getBytes()));
                
                System.out.println("Simulating work for 2 seconds while holding the lock...");
                Thread.sleep(2000);
                
                // The lock is automatically released here because of try-with-resources.
            }
            
            System.out.println("Lock released automatically.");
        }
        
        // Clean up
        new java.io.File(logFile).delete();
    }
}
