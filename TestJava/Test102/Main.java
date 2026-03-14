package TestJava.Test102;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Memory-Mapped Files (MappedByteBuffer) ===\n");

        // Memory Mapped Files map a file directly directly into the Virtual Memory of the OS.
        // Reading/writing from this buffer bypasses standard I/O streams entirely!
        // It's insanely fast for huge files (like databases).
        
        String filePath = "TestJava/Test102/vast_memory.bin";
        // Create an empty 1MB file via RandomAccessFile
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw")) {
            file.setLength(1024 * 1024); // 1 MB file
        }

        System.out.println("--- 1. Mapping the file to RAM ---");
        try (RandomAccessFile file = new RandomAccessFile(filePath, "rw");
             FileChannel channel = file.getChannel()) {
             
            // Map the entire 1MB file into memory starting at position 0.
            MappedByteBuffer mappedBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
            
            System.out.println("Buffer mapped. Size: " + mappedBuffer.capacity() + " bytes");

            System.out.println("\n--- 2. Writing directly to Memory ---");
            // Writing to this buffer immediately alters the file on disk (eventually synced by the OS)
            mappedBuffer.put(0, (byte) 'M');
            mappedBuffer.put(1, (byte) 'M');
            mappedBuffer.put(2, (byte) 'P');
            System.out.println("Wrote 'MMP' to the start of the memory map.");

            System.out.println("\n--- 3. Reading directly from Memory ---");
            char firstChar = (char) mappedBuffer.get(0);
            System.out.println("Read from position 0: " + firstChar);
            
            // In high-performance systems (like Kafka or Cassandra), they use this technique
            // so they don't have to load gigabytes of files into ArrayLists!
            
            // Sync forcing (Tells the OS to flush changes to disk immediately)
            mappedBuffer.force(); 
        }
        
        // Clean up
        new java.io.File(filePath).delete();
    }
}
