/**
 * Interviewer: Why default methods in interfaces?
 * Candidate: To add new methods to interfaces without breaking existing implementations.
 */
interface MyInt {
    default void log() { System.out.println("Log item"); }
}
public class Q2_Default_Methods { }
