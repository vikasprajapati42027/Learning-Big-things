package TestJava.Test134;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    // A series of nested calls to build up a stack
    public static void main(String[] args) {
        System.out.println("=== StackWalker API (Java 9+) ===\n");

        System.out.println("Historically, developers used 'Thread.currentThread().getStackTrace()' to inspect the Call Stack.");
        System.out.println("This was slow and inflexible. StackWalker is lazy-evaluated, stream-based, and highly performant!\n");
        
        levelOne();
    }

    private static void levelOne() {
        levelTwo();
    }

    private static void levelTwo() {
        levelThree();
    }

    private static void levelThree() {
        System.out.println("Reached Level Three! Let's inspect how we got here:");
        
        // Get the default StackWalker
        StackWalker walker = StackWalker.getInstance();
        
        // 1. Walk the stack entirely as a Stream!
        List<String> callerMethods = walker.walk(frames -> 
            frames.map(StackWalker.StackFrame::getMethodName)
                  .collect(Collectors.toList())
        );
        
        System.out.println("\nFull Call Stack (Methods only):");
        System.out.println(callerMethods);
        
        // 2. Getting exactly the caller of this specific method
        // Using RETAIN_CLASS_REFERENCE lets us access the actual Class objects!
        StackWalker advancedWalker = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE);
        
        Class<?> callerClass = advancedWalker.getCallerClass(); // Finds who called 'levelThree'
        
        System.out.println("\nDirect Caller Class: " + callerClass.getName());
        
        // 3. Finding specific frames using Streams
        System.out.println("\nDetailed Frame Info:");
        advancedWalker.forEach(frame -> {
            System.out.printf(" - %s() in %s.java (Line %d)%n", 
                frame.getMethodName(), 
                frame.getFileName(), 
                frame.getLineNumber());
        });
    }
}
