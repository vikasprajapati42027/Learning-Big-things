package java_version.Java8_version.lambda.test18;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.*;

/** test18: Stream from files – Files.lines (requires path) */
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== test18: Stream from Path ===\n");
        Path p = Paths.get("java_version/Java8-version/lambda/test18/sample.txt");
        Files.write(p, Arrays.asList("line1", "line2", "line3"));
        try (Stream<String> lines = Files.lines(p)) {
            List<String> content = lines.collect(Collectors.toList());
            System.out.println("Files.lines: " + content);
        }
    }
}
