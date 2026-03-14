package TestJava.Test101;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== AsynchronousFileChannel Tutorial ===\n");

        Path path = Paths.get("TestJava/Test101/async.txt");
        
        // --- 1. Writing Asynchronously ---
        System.out.println("--- 1. Writing Async ---");
        try (AsynchronousFileChannel writeChannel = AsynchronousFileChannel.open(path, 
                StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            
            ByteBuffer buffer = ByteBuffer.wrap("Asynchronous I/O is totally awesome!".getBytes());
            
            // Uses a 'Future' just like Callable
            Future<Integer> operation = writeChannel.write(buffer, 0); // Write at position 0
            
            System.out.println("Write operation launched. Doing other things while OS writes...");
            
            // Block until it finishes
            operation.get(); 
            System.out.println("Write complete!\n");
        }

        // --- 2. Reading Asynchronously ---
        System.out.println("--- 2. Reading Async with Callback ---");
        try (AsynchronousFileChannel readChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {
            
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            
            // Instead of a Future, wait for a Callback (CompletionHandler)
            readChannel.read(readBuffer, 0, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                @Override
                public void completed(Integer result, ByteBuffer attachment) {
                    System.out.println("Callback Triggered! Bytes read: " + result);
                    attachment.flip();
                    System.out.println("Content: " + new String(attachment.array(), 0, result));
                }

                @Override
                public void failed(Throwable exc, ByteBuffer attachment) {
                    System.out.println("Failed to read file!");
                    exc.printStackTrace();
                }
            });
            
            System.out.println("Read operation launched. Main thread is doing other work...");
            // Keep main thread alive long enough for async read to finish
            Thread.sleep(1000);
        }
    }
}
