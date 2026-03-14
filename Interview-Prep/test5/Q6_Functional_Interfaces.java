/**
 * Interviewer: Name some standard functional interfaces.
 * Candidate: Predicate (returns bool), Consumer (consumes value), Supplier (produces value), Function (transforms value).
 */
import java.util.function.*;
public class Q6_Functional_Interfaces {
    Predicate<String> isEmpty = s -> s.isEmpty();
}
