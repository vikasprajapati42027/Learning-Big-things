package java_version.Java8_version.lambda.test5;

import java.util.*;
import java.util.stream.Collectors;

/** test5: Optional – orElse, orElseGet, ifPresent, map, filter */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test5: Optional ===\n");
        Optional<String> full = Optional.of("hello");
        Optional<String> empty = Optional.empty();
        System.out.println("orElse: " + full.orElse("x") + ", " + empty.orElse("x"));
        empty.ifPresent(s -> System.out.println("won't print"));
        full.ifPresent(s -> System.out.println("ifPresent: " + s));
        System.out.println("map length: " + full.map(String::length).orElse(0));
        System.out.println("filter: " + full.filter(s -> s.length() > 3).orElse(""));
    }
}
