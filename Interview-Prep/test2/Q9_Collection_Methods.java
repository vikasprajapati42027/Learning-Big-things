/**
 * Interviewer: Collections.unmodifiableList vs List.of?
 * Candidate: unmodifiableList is a view (Source can change). List.of is truly Immutable (Fixed).
 */
import java.util.*;
public class Q9_Collection_Methods {
    public static void main(String[] args) {
        List<String> list = List.of("A", "B"); // Java 9+ Immutable
    }
}
