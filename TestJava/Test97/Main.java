package TestJava.Test97;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Java NIO Channels (FileChannel) ===\n");

        String sourceFile = "TestJava/Test97/source.txt";
        String destFile = "TestJava/Test97/dest.txt";

        // Create quick source file for testing
        try (FileOutputStream out = new FileOutputStream(sourceFile)) {
            out.write("Hello from NIO Channels! This is extremely fast file copying.".getBytes());
        }

        System.out.println("--- Reading & Writing using Channels and Buffers ---");

        // Open streams to get their underlying Channels
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileChannel readChannel = fis.getChannel();
             FileOutputStream fos = new FileOutputStream(destFile);
             FileChannel writeChannel = fos.getChannel()) {

            // Create a small buffer (e.g., 16 bytes) to show iteration
            ByteBuffer buffer = ByteBuffer.allocate(16);

            // Read from channel into buffer
            while (readChannel.read(buffer) != -1) {
                // FLIP buffer to prepare for writing
                buffer.flip();

                // Write from buffer into channel
                writeChannel.write(buffer);

                // CLEAR buffer to prepare for next read
                buffer.clear();
            }
            System.out.println("File copied successfully block by block!");

            // --- ZERO-COPY Optimization ---
            // Operating systems can transfer data directly between channels without loading 
            // the data into the JVM memory space! This is "Zero-Copy" and is incredibly fast.
            System.out.println("\n--- Fast Transfer (Zero-Copy) ---");
            
            // Reset position to read again
            readChannel.position(0); 
            
            String destZeroCopy = "TestJava/Test97/dest_zerocopy.txt";
            try (FileOutputStream fos2 = new FileOutputStream(destZeroCopy);
                 FileChannel fastWriteChannel = fos2.getChannel()) {
                
                // transferTo() or transferFrom() triggers Zero-Copy if the OS supports it!
                readChannel.transferTo(0, readChannel.size(), fastWriteChannel);
                System.out.println("Copied using Zero-Copy (transferTo)!");
            }
        }
    }
}
