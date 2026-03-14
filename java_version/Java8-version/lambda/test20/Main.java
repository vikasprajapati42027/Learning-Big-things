package java_version.Java8_version.lambda.test20;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** test20: Stream toArray */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test20: toArray ===\n");
        List<String> list = Arrays.asList("a", "b", "c");
        Object[] arr = list.stream().toArray();
        System.out.println("toArray(): " + Arrays.toString(arr));
        String[] strArr = list.stream().toArray(String[]::new);
        System.out.println("toArray(String[]::new): " + Arrays.toString(strArr));
        int[] intArr = Stream.of(1, 2, 3).mapToInt(i -> i).toArray();
        System.out.println("mapToInt toArray: " + Arrays.toString(intArr));
    }
}
