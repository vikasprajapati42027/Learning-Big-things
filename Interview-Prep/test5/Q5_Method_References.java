/**
 * Interviewer: Method References?
 * Candidate: Shorthand for Lambdas to call existing methods using :: syntax.
 */
import java.util.*;
public class Q5_Method_References {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("A", "B");
        list.forEach(System.out::println); // Method ref
    }
}
