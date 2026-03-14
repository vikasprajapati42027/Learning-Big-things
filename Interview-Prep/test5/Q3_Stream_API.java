/**
 * Interviewer: What is Stream API?
 * Candidate: A pipeline to process collections using functional style (Filter, Map, Reduce).
 */
import java.util.*;
public class Q3_Stream_API {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().filter(n -> n > 1).forEach(System.out::println);
    }
}
