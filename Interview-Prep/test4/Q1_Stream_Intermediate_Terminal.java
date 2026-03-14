import java.util.stream.*;
import java.util.*;
public class Q1_Stream_Intermediate_Terminal {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        // Intermediate: map, filter
        // Terminal: collect, reduce, forEach
        list.stream().filter(n -> n > 1).forEach(System.out::println);
    }
}


            