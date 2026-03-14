package java_version.Java8_version.lambda.test10;

import java.util.*;
import java.util.stream.Collectors;

/** test10: Optional chaining – map, flatMap, filter, orElseThrow */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test10: Optional chaining ===\n");
        Optional<String> opt = Optional.of("  hello  ");
        Optional<Integer> len = opt.map(String::trim).map(String::length);
        System.out.println("map trim then length: " + len.orElse(-1));
        Optional<String> filtered = opt.filter(s -> s.length() > 2);
        System.out.println("filter length>2: " + filtered.orElse(""));
        String value = Optional.of("ok").orElseThrow();
        System.out.println("orElseThrow: " + value);
    }
}
