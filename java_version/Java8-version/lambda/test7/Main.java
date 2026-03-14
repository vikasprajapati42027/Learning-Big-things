package java_version.Java8_version.lambda.test7;

import java.util.*;
import java.util.stream.Collectors;

/** test7: Comparator – thenComparing, reversed, nullsFirst */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test7: Comparator ===\n");
        List<String> words = Arrays.asList("cat", "apple", "go", "banana");
        List<String> byLen = words.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        System.out.println("by length: " + byLen);
        List<String> byLenRev = words.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.toList());
        System.out.println("by length reversed: " + byLenRev);
        List<String> byLenThenAlpha = words.stream().sorted(Comparator.comparing(String::length).thenComparing(s -> s)).collect(Collectors.toList());
        System.out.println("length then alpha: " + byLenThenAlpha);
    }
}
