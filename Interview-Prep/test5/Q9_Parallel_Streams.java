/**
 * Interviewer: Parallel Streams?
 * Candidate: Uses ForkJoinPool to process data across multiple CPU cores automatically.
 */
import java.util.*;
public class Q9_Parallel_Streams {
    public static void main(String[] args) {
        List.of(1, 2).parallelStream().forEach(System.out::println);
    }
}
