package TestJava.Test235;

// A Ring Buffer uses a fixed-size array but wraps the read/write pointers around.
// It NEVER needs to allocate new memory. It's incredibly fast (O(1) everything).
class CircularBuffer {
    private final int[] buffer;
    private int head = 0; // Where we read from
    private int tail = 0; // Where we write to
    private int count = 0; // How many items are in the buffer
    
    public CircularBuffer(int size) {
        buffer = new int[size];
    }
    
    public void enqueue(int item) {
        if (count == buffer.length) {
            System.out.println("[Warning] Buffer Full! Overwriting oldest data: " + buffer[head]);
            head = (head + 1) % buffer.length; // Move head to forget oldest data
        } else {
            count++;
        }
        
        buffer[tail] = item;
        System.out.println("Enqueued: " + item + " at index " + tail);
        tail = (tail + 1) % buffer.length; // Wrap around if tail hits the end
    }
    
    public Integer dequeue() {
        if (count == 0) {
            System.out.println("[Warning] Buffer Empty!");
            return null;
        }
        
        int item = buffer[head];
        head = (head + 1) % buffer.length; // Wrap around
        count--;
        
        System.out.println("Dequeued: " + item);
        return item;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 235: Circular Buffer (Ring Buffer) ===\n");

        System.out.println("A Circular Buffer is used in Networking (Packet Queues) and Audio/Video streaming.");
        System.out.println("It uses a fixed array and loop-arounds to achieve O(1) performance without memory allocation!\n");

        CircularBuffer cb = new CircularBuffer(3); // A tiny buffer!
        
        cb.enqueue(10);
        cb.enqueue(20);
        cb.enqueue(30); // Buffer is now FULL!
        
        System.out.println("\n-- Adding 4th item to a 3-item Ring --");
        // This will overwrite '10' and push the head to index 1 (where '20' is)
        cb.enqueue(40); 
        
        System.out.println("\n-- Emptying the Buffer --");
        cb.dequeue(); // Should be 20 (since 10 was overwritten)
        cb.dequeue(); // Should be 30
        cb.dequeue(); // Should be 40
        cb.dequeue(); // Empty!
        
        System.out.println("\n-- Adding new values (Pointers naturally wrapped around!) --");
        cb.enqueue(50);
        cb.enqueue(60);
        cb.dequeue();
    }
}
