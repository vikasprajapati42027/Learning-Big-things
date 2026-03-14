/**
 * Interviewer: What is propagation?
 * Candidate: An exception not caught in a method automatically bubbles up to the caller.
 */
public class Q9_Exception_Propagation {
    void a() { b(); }
    void b() { throw new RuntimeException("Bubbling up"); }
}
