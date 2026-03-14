/**
 * Interviewer: Can finally block be skipped?
 * Candidate: Yes, if System.exit(0) is called or the JVM crashes.
 */
public class Q3_Finally_Skip {
    public static void main(String[] args) {
        try { System.exit(0); }
        finally { System.out.println("Won't run!"); }
    }
}
