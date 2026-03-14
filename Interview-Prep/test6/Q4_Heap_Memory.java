/**
 * Interviewer: Difference between Heap and Stack?
 * Candidate: Heap is for all object storage. Stack is for primitive local variables and method call stack.
 */
public class Q4_Heap_Memory {
    public static void main(String[] args) {
        // obj resides on Heap. local variable 'obj' reference is on Stack.
        Object obj = new Object();
        int primitive = 10; // Entirely on Stack
        System.out.println("Memory: Heap for Objects, Stack for locals.");
    }
}
