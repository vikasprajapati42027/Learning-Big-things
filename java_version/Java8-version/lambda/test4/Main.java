package java_version.Java8_version.lambda.test4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 Lambda & Stream - Basic to Advanced Interview Q&A
 * Run: javac java_version/Java8-version/lambda/test4/Main.java
 *      java -cp . java_version.Java8_version.lambda.test4.Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java 8: Basic to Advanced Q&A ===\n");

        // ---------- BASIC ----------

        // Q1 (Basic): What is the syntax of a lambda with one parameter?
        // Answer: (param) -> expression   or   param -> expression (no parens if single param)
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(x -> System.out.print(x + " "));
        System.out.println("  [Q1: forEach with lambda]");

        // Q2 (Basic): How do you filter elements in a Stream?
        // Answer: .filter(Predicate) — keeps only elements where the condition is true
        List<Integer> evens = list.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Q2 Filter evens: " + evens);

        // Q3 (Basic): What does map() do?
        // Answer: Transforms each element. map(x -> x*2) gives a new stream with each element doubled.
        List<Integer> doubled = list.stream().map(n -> n * 2).collect(Collectors.toList());
        System.out.println("Q3 Map double: " + doubled);

        // Q4 (Basic): Difference between map and flatMap?
        // Answer: map = 1-to-1. flatMap = 1-to-many, then flattens (e.g. list of lists -> single list)
        List<List<Integer>> nested = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4));
        List<Integer> flat = nested.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println("Q4 FlatMap: " + flat);

        // Q5 (Basic): How to get first element of a Stream?
        // Answer: .findFirst() returns Optional<T>. Use .orElse(default) or .get() (if present)
        Optional<Integer> first = list.stream().filter(n -> n > 1).findFirst();
        System.out.println("Q5 FindFirst: " + first.orElse(-1));

        // Q6 (Basic): What does reduce do?
        // Answer: Combines all elements into one value. identity = initial value, accumulator = (a,b) -> result
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Q6 Reduce sum: " + sum);

        // Q7 (Basic): How to remove duplicates in a Stream?
        // Answer: .distinct() — uses equals() to drop duplicates
        List<Integer> withDupes = Arrays.asList(1, 2, 1, 3, 2);
        List<Integer> unique = withDupes.stream().distinct().collect(Collectors.toList());
        System.out.println("Q7 Distinct: " + unique);

        // Q8 (Basic): How to sort a Stream?
        // Answer: .sorted() for natural order, .sorted(Comparator.reverseOrder()) for reverse
        List<Integer> sorted = Arrays.asList(3, 1, 2).stream().sorted().collect(Collectors.toList());
        System.out.println("Q8 Sorted: " + sorted);

        // Q9 (Basic): What are limit and skip?
        // Answer: limit(n) = take first n elements. skip(n) = skip first n elements.
        List<Integer> limited = list.stream().limit(2).collect(Collectors.toList());
        List<Integer> skipped = list.stream().skip(1).collect(Collectors.toList());
        System.out.println("Q9 Limit(2): " + limited + ", Skip(1): " + skipped);

        // Q10 (Basic): What is Optional? Why use it?
        // Answer: Optional<T> wraps a value that might be absent. Avoids null; use orElse(), ifPresent(), get()
        Optional<String> opt = Optional.of("hello");
        System.out.println("Q10 Optional: " + opt.orElse("empty"));

        // ---------- INTERMEDIATE ----------

        // Q11 (Intermediate): How to group by a key? Example: group strings by length
        // Answer: Collectors.groupingBy(classifier). groupingBy(String::length) -> Map<Integer, List<String>>
        List<String> words = Arrays.asList("a", "ab", "abc", "b", "bc");
        Map<Integer, List<String>> byLength = words.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Q11 Group by length: " + byLength);

        // Q12 (Intermediate): How to partition (split into two groups by condition)?
        // Answer: Collectors.partitioningBy(Predicate) -> Map<Boolean, List<T>>
        Map<Boolean, List<Integer>> oddEven = list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Q12 PartitioningBy odd/even: " + oddEven);

        // Q13 (Intermediate): How to collect Stream to Map (key-value)?
        // Answer: Collectors.toMap(keyMapper, valueMapper). Keys must be unique.
        List<String> keys = Arrays.asList("one", "two", "three");
        Map<String, Integer> map = keys.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println("Q13 ToMap (word -> length): " + map);

        // Q14 (Intermediate): How to sort by a custom field? Example: sort by string length then alphabetically
        // Answer: .sorted(Comparator.comparing(String::length).thenComparing(Function.identity()))
        List<String> toSort = Arrays.asList("cat", "a", "go", "dog");
        List<String> byLenThenAlpha = toSort.stream()
                .sorted(Comparator.comparing(String::length).thenComparing(Function.identity()))
                .collect(Collectors.toList());
        System.out.println("Q14 Sort by length then alpha: " + byLenThenAlpha);

        // Q15 (Intermediate): What is method reference? Give examples.
        // Answer: Shorthand for lambda. String::length = s -> s.length(), System.out::println = x -> System.out.println(x)
        list.stream().map(Object::toString).forEach(System.out::print);
        System.out.println("  [Q15 method ref]");

        // Q16 (Intermediate): Count frequency of each element
        // Answer: groupingBy(Function.identity(), Collectors.counting())
        List<String> letters = Arrays.asList("a", "b", "a", "c", "a");
        Map<String, Long> freq = letters.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Q16 Frequency: " + freq);

        // Q17 (Intermediate): Join strings with delimiter, prefix, suffix
        // Answer: Collectors.joining(delimiter, prefix, suffix)
        String joined = words.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("Q17 Joining: " + joined);

        // Q18 (Intermediate): Get max / min from Stream
        // Answer: .max(Comparator) / .min(Comparator). Returns Optional.
        OptionalInt max = Arrays.asList(10, 5, 20).stream().mapToInt(i -> i).max();
        OptionalInt min = Arrays.asList(10, 5, 20).stream().mapToInt(i -> i).min();
        System.out.println("Q18 Max: " + max.getAsInt() + ", Min: " + min.getAsInt());

        // ---------- ADVANCED ----------

        // Q19 (Advanced): Second largest number in a list
        // Answer: sort reverse, skip(1), findFirst
        List<Integer> nums = Arrays.asList(10, 5, 20, 8, 15);
        Optional<Integer> secondMax = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Q19 Second largest: " + secondMax.orElse(-1));

        // Q20 (Advanced): Merge two lists and remove duplicates, sorted
        // Answer: Stream.concat(list1.stream(), list2.stream()).distinct().sorted().collect(toList())
        List<Integer> listA = Arrays.asList(3, 1, 2);
        List<Integer> listB = Arrays.asList(2, 3, 4);
        List<Integer> merged = Stream.concat(listA.stream(), listB.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println("Q20 Merge unique sorted: " + merged);

        // Q21 (Advanced): Sum of list of integers using reduce with identity and combiner (for parallel)
        // Answer: reduce(identity, accumulator, combiner). Combiner used when stream is parallel.
        int sumReduce = list.stream().reduce(0, Integer::sum, Integer::sum);
        System.out.println("Q21 Reduce with combiner: " + sumReduce);

        // Q22 (Advanced): Collect to unmodifiable list (Java 10+)
        // Answer: .toList() (Java 16) or Collectors.toUnmodifiableList() (Java 10)
        List<String> unmod = words.stream().collect(Collectors.toUnmodifiableList());
        System.out.println("Q22 Unmodifiable list size: " + unmod.size());

        // Q23 (Advanced): Find duplicate elements in a list using Stream
        // Answer: Use a Set; filter(i -> !set.add(i)) gives duplicates
        Set<Integer> set = new HashSet<>();
        Set<Integer> dups = withDupes.stream().filter(i -> !set.add(i)).collect(Collectors.toSet());
        System.out.println("Q23 Duplicates: " + dups);

        // Q24 (Advanced): IntStream to List<Integer>
        // Answer: IntStream.range(1, 11).boxed().collect(Collectors.toList())
        List<Integer> fromIntStream = IntStream.range(1, 6).boxed().collect(Collectors.toList());
        System.out.println("Q24 IntStream to List: " + fromIntStream);

        // Q25 (Advanced): Stream.iterate — generate first N Fibonacci numbers
        // Answer: Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0]+f[1]}).limit(N).map(f -> f[0])
        System.out.print("Q25 Fibonacci first 8: ");
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                .limit(8)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n=== Done (Basic to Advanced) ===");
    }
}
