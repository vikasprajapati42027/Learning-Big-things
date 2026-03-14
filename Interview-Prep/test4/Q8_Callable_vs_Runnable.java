/**
 * Interviewer: Callable vs Runnable?
 * Candidate: Callable can return a result and throw checked exceptions. Runnable cannot.
 */
import java.util.concurrent.*;
public class Q8_Callable_vs_Runnable {
    Callable<String> task = () -> "Result";
}
