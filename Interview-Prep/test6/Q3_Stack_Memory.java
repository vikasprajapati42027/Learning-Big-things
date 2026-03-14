/**
 * Interviewer: What happens in the Stack when a method is called?
 * Candidate: A new 'Stack Frame' is pushed onto the thread's stack.
 */
public class Q3_Stack_Memory {
    public static void main(String[] args) {
        System.out.println("Stack: Stores local variables and partial results.");
        methodA(10);
    }
    
    static void methodA(int val) {
        int x = val + 5; // Stored in current stack frame
        System.out.println("Stack Frame A: Local x = " + x);
    }
}
