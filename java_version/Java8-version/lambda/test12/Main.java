package java_version.Java8_version.lambda.test12;

import java.util.*;
import java.util.stream.Collectors;

/** test12: String/char stream – chars(), codePoints(), split to stream */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test12: String Stream ===\n");
        String s = "hello";
        List<Character> chars = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        System.out.println("chars(): " + chars);
        Map<Character, Long> freq = s.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("char frequency: " + freq);
        List<String> words = Arrays.stream("a b c".split(" ")).collect(Collectors.toList());
        System.out.println("split stream: " + words);
    }
}
