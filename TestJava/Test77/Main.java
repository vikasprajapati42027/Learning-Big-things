package TestJava.Test77;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ArrayDeque (Stack & Queue) Tutorial ===\n");

        // ArrayDeque (Double Ended Queue) is the modern, fast replacement for legacy Stack and LinkedList.
        // It allows adding or removing elements from BOTH ends.

        System.out.println("--- 1. Using it as a Stack (LIFO: Last-In, First-Out) ---");
        // Push items onto the stack (like a stack of plates)
        Deque<String> stack = new ArrayDeque<>();
        stack.push("Plate 1");
        stack.push("Plate 2");
        stack.push("Plate 3");
        
        System.out.println("Stack contents: " + stack);
        System.out.println("Popping top item: " + stack.pop()); // Removes and returns the top
        System.out.println("Stack contents after pop: " + stack);


        System.out.println("\n--- 2. Using it as a Queue (FIFO: First-In, First-Out) ---");
        // Add items to the back, take items from the front (like a ticket line)
        Deque<String> queue = new ArrayDeque<>();
        queue.offer("Person 1");
        queue.offer("Person 2");
        queue.offer("Person 3");
        
        System.out.println("Queue contents: " + queue);
        System.out.println("Polling front item: " + queue.poll()); // Removes and returns the front
        System.out.println("Queue contents after poll: " + queue);

        System.out.println("\n--- 3. Using it as a Deque (Both ends) ---");
        Deque<String> deque = new ArrayDeque<>();
        deque.addFirst("FrontItem");
        deque.addLast("BackItem");
        System.out.println("Deque: " + deque);
    }
}
