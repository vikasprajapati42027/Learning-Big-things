/**
 * INTERVIEWER: What is the Iterator Pattern?
 * CANDIDATE: It provides a way to access elements of an aggregate object sequentially without exposing its representation.
 */
import java.util.*;
public class Q4_Iterator {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", "Kotlin", "Scala");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println("Language: " + it.next());
        }
    }
}
