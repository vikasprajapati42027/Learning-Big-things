/**
 * Interviewer: map() vs flatMap()?
 * Candidate: map() transforms one item. flatMap() transforms one item into a Stream and flattens it.
 */
import java.util.stream.Stream;
public class Q7_Map_vs_FlatMap {
    void demo() {
        Stream.of(1, 2).map(n -> n * 10);
    }
}
