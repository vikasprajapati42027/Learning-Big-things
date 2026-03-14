package TestJava.Test96;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Java NIO Buffers (ByteBuffer) ===\n");

        // NIO (New I/O) is built around Channels and Buffers.
        // Data is ALWAYS read from a Channel into a Buffer, or written from a Buffer to a Channel.
        
        // 1. Allocate a ByteBuffer of 10 bytes
        ByteBuffer buffer = ByteBuffer.allocate(10);
        
        System.out.println("--- 1. Initial State ---");
        printBufferState(buffer); // Capacity: 10, Limit: 10, Position: 0

        // 2. Writing Data INTO the Buffer
        System.out.println("\n--- 2. Writing Data (Putting 'Java') ---");
        buffer.put((byte) 'J');
        buffer.put((byte) 'a');
        buffer.put((byte) 'v');
        buffer.put((byte) 'a');
        printBufferState(buffer); // Capacity: 10, Limit: 10, Position: 4

        // 3. FLIPPING the Buffer
        // This is CRUCIAL! Before you can READ from a buffer you wrote to, you MUST flip it.
        // flip() sets the Limit to the current Position, and sets Position back to 0.
        System.out.println("\n--- 3. Flipping the Buffer (Ready for Reading) ---");
        buffer.flip();
        printBufferState(buffer); // Capacity: 10, Limit: 4, Position: 0

        // 4. Reading Data FROM the Buffer
        System.out.println("\n--- 4. Reading Data ---");
        while (buffer.hasRemaining()) {
            System.out.print((char) buffer.get() + " ");
        }
        System.out.println();
        printBufferState(buffer); // Capacity: 10, Limit: 4, Position: 4

        // 5. CLEARING the Buffer
        // clear() doesn't erase the actual data, but it resets Limit to Capacity and Position to 0
        // so you can overwrite it!
        System.out.println("\n--- 5. Clearing the Buffer (Ready for Overwriting) ---");
        buffer.clear();
        printBufferState(buffer); // Capacity: 10, Limit: 10, Position: 0
    }

    private static void printBufferState(ByteBuffer buffer) {
        System.out.printf("Position: %d, Limit: %d, Capacity: %d%n", 
            buffer.position(), buffer.limit(), buffer.capacity());
    }
}
