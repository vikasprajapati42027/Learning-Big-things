package java_version.Java8_version.lambda.test9;

import java.util.stream.Stream;

/** test9: Stream generation – iterate, limit */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test9: Stream iterate ===\n");
        Stream.iterate(0, n -> n + 2).limit(5).forEach(n -> System.out.print(n + " "));
        System.out.println();
        Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0]+f[1]}).limit(6).map(f -> f[0]).forEach(n -> System.out.print(n + " "));
        System.out.println();
    }
}
