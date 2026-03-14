/**
 * Interviewer: What are Collectors?
 * Candidate: Used at the end of a Stream to collect results into a List, Set, or Map.
 */
import java.util.*;
import java.util.stream.*;
public class Q8_Collectors {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2).collect(Collectors.toList());
    }
}
