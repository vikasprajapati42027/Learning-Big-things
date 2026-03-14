/**
 * Interview Prep: Test 3 - Exception Handling
 * 10 Simple Examples with Explanation
 */

// 1. Checked vs Unchecked
// Checked: Compiler forces you to handle (e.g., IOException).
// Unchecked: Runtime issues (e.g., NullPointerException).
import java.io.*;

class Q1 {
    void checked() throws IOException { throw new IOException(); }
    void unchecked() { throw new RuntimeException(); }
}

// 2. Try-Catch-Finally
// finally always runs, used for closing files or DB connections.
class Q2 {
    void demo() {
        try { int x = 10/0; }
        catch(ArithmeticException e) { System.out.println("Error"); }
        finally { System.out.println("Cleanup"); }
    }
}

// 3. Try-with-Resources (Java 7+)
// Automatically closes resources like BufferedReader.
class Q3 {
    void demo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
            System.out.println(br.readLine());
        } // br closed automatically
    }
}

// 4. Throw vs Throws
// throw: triggers an exception. throws: declares an exception in method signature.
class Q4 {
    void method() throws Exception { throw new Exception("Manual trigger"); }
}

// 5. Multiple Catch Blocks
// Always catch specialized exceptions before broad ones.
class Q5 {
    void demo() {
        try { }
        catch(NullPointerException e) { }
        catch(Exception e) { } // Broad one must be last
    }
}

// 6. Custom Exception
// Create your own by extending Exception or RuntimeException.
class MyException extends Exception {
    public MyException(String msg) { super(msg); }
}

// 7. Exception Propagation
// If not caught in a method, it goes up to the caller.
class Q7 {
    void a() { b(); }
    void b() { throw new RuntimeException(); }
}

// 8. Error vs Exception
// Error: Critical system failure (Out of Memory).
// Exception: Application level issue (File not found).
class Q8 { }

// 9. Can finally be skipped?
// Only if System.exit(0) is called or the JVM crashes.
class Q9 {
    void demo() {
        try { System.exit(0); }
        finally { /* This wont run */ }
    }
}

// 10. NullPointerException prevention
// Use checks or Optional instead of direct access.
class Q10 {
    void demo(String s) {
        if(s != null) System.out.println(s.length());
    }
}

public class QUESTIONS {
    public static void main(String[] args) {
        System.out.println("10 Exception Handling Questions with Code Ready.");
    }
}
