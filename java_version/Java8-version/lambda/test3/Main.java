package java_version.Java8_version.lambda.test3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Java 8 Stream & Lambda - Completed code (Cheat sheet style)
 * Run: javac java_version/Java8-version/lambda/test3/Main.java
 *      java -cp . java_version.Java8_version.lambda.test3.Main
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java 8 Stream / Lambda - Completed Examples ===\n");

        // 1. Separate Odd And Even Numbers
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> oddEven = listOfIntegers.stream()
                .collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("1. Odd & Even: " + oddEven);

        // 2. Frequency Of Each Character In String
        String inputString = "hello";
        Map<Character, Long> charFreq = inputString.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("2. Char frequency: " + charFreq);

        // 3. Sort The List In Reverse Order
        List<Integer> anyList = Arrays.asList(3, 1, 4, 1, 5);
        System.out.print("3. Reverse order: ");
        anyList.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // 4. Print Multiples Of 5 From The List
        System.out.print("4. Multiples of 5: ");
        listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // 5. Merge Two Unsorted Arrays Into Single Sorted Array
        int[] a = { 3, 1, 4 };
        int[] b = { 2, 5, 0 };
        int[] merged = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().toArray();
        System.out.println("5. Merged sorted: " + Arrays.toString(merged));

        // 6. Merge Two Unsorted Arrays Without Duplicates
        int[] c = { 1, 2, 3 };
        int[] d = { 2, 3, 4 };
        int[] mergedDistinct = IntStream.concat(Arrays.stream(c), Arrays.stream(d)).sorted().distinct().toArray();
        System.out.println("6. Merged no duplicates: " + Arrays.toString(mergedDistinct));

        // 7. Three Max & Min Numbers From The List
        System.out.print("7. Min 3: ");
        listOfIntegers.stream().sorted().limit(3).forEach(x -> System.out.print(x + " "));
        System.out.print(" | Max 3: ");
        listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // 8. Sort List Of Strings In Increasing Order Of Their Length
        List<String> listOfStrings = Arrays.asList("cat", "a", "elephant", "go");
        System.out.print("8. By length: ");
        listOfStrings.stream().sorted(Comparator.comparing(String::length)).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 9. Sum & Average Of All Elements Of An Array
        // Sum: Arrays.stream(inputArray).sum();
        // Average: Arrays.stream(inputArray).average().getAsDouble();
        int[] inputArray = { 10, 20, 30, 40 };
        int sum = Arrays.stream(inputArray).sum();
        double avg = Arrays.stream(inputArray).average().orElse(0);
        double avgAsDouble = Arrays.stream(inputArray).average().getAsDouble();
        System.out.println("9. Sum: " + sum + ", Average: " + avg + " (getAsDouble: " + avgAsDouble + ")");

        // 10. Reverse An Integer Array
        int[] array = { 1, 2, 3, 4 };
        int[] reversed = IntStream.rangeClosed(1, array.length).map(i -> array[array.length - i]).toArray();
        System.out.println("10. Reversed array: " + Arrays.toString(reversed));

        // 11. Palindrome Program In Java 8 (two ways)
        // Way 1: reverse and compare
        String word = "madam";
        String reversedStr = word.chars().mapToObj(c -> (char) c)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    Collections.reverse(list);
                    return list.stream().map(String::valueOf).collect(Collectors.joining());
                }));
        boolean isPalindrome = word.equals(reversedStr);
        // Way 2: IntStream.range(0, str.length()/2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        String strPalindrome = "madam";
        boolean isPalindromeNoneMatch = IntStream.range(0, strPalindrome.length() / 2)
                .noneMatch(i -> strPalindrome.charAt(i) != strPalindrome.charAt(strPalindrome.length() - i - 1));
        System.out.println("11. Is palindrome '" + word + "': " + isPalindrome + " (noneMatch: " + isPalindromeNoneMatch + ")");

        // 12. Remove Duplicate Elements From List
        List<String> withDupes = Arrays.asList("a", "b", "a", "c", "b");
        List<String> distinct = withDupes.stream().distinct().collect(Collectors.toList());
        System.out.println("12. Distinct: " + distinct);

        // 13. Frequency Of Each Element In An Array
        List<String> anyListStr = Arrays.asList("a", "b", "a", "a", "c");
        Map<String, Long> elemFreq = anyListStr.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("13. Element frequency: " + elemFreq);

        // 14. Join List Of Strings With Prefix, Suffix And Delimiter
        List<String> toJoin = Arrays.asList("one", "two", "three");
        String joined = toJoin.stream().collect(Collectors.joining(", ", "[", "]"));
        System.out.println("14. Joined: " + joined);

        // 15. Maximum & Minimum In A List
        OptionalInt maxOpt = listOfIntegers.stream().mapToInt(i -> i).max();
        OptionalInt minOpt = listOfIntegers.stream().mapToInt(i -> i).min();
        System.out.println("15. Max: " + maxOpt.getAsInt() + ", Min: " + minOpt.getAsInt());

        // 16. Anagram Program In Java 8
        String s1 = "listen";
        String s2 = "silent";
        String sorted1 = Stream.of(s1.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        String sorted2 = Stream.of(s2.split("")).map(String::toUpperCase).sorted().collect(Collectors.joining());
        boolean anagram = sorted1.equals(sorted2);
        System.out.println("16. Anagram '" + s1 + "' & '" + s2 + "': " + anagram);

        // 17. Sum Of All Digits Of A Number
        int inputNumber = 12345;
        int digitSum = Stream.of(String.valueOf(inputNumber).split(""))
                .collect(Collectors.summingInt(Integer::parseInt));
        System.out.println("17. Sum of digits of " + inputNumber + ": " + digitSum);

        // 18. Second Largest Number In An Integer Array
        List<Integer> forSecond = Arrays.asList(10, 5, 20, 8, 15);
        int secondLargest = forSecond.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println("18. Second largest: " + secondLargest);

        // 19. Common Elements Between Two Arrays
        List<String> list1 = Arrays.asList("a", "b", "c");
        List<String> list2 = Arrays.asList("b", "c", "d");
        System.out.print("19. Common elements: ");
        list1.stream().filter(list2::contains).forEach(x -> System.out.print(x + " "));
        System.out.println();

        // 20. Reverse Each Word Of A String
        // Arrays.stream(str.split(" ")).map(word -> new StringBuffer(word).reverse()).collect(Collectors.joining(" "));
        String str = "hello world java";
        String reversedWords = Arrays.stream(str.split(" "))
                .map(w -> new StringBuilder(w).reverse().toString())
                .collect(Collectors.joining(" "));
        System.out.println("20. Reverse each word: " + reversedWords);

        // 21. Sum Of First 10 Natural Numbers
        int sum10 = IntStream.range(1, 11).sum();
        System.out.println("21. Sum 1..10: " + sum10);

        // 22. Find Strings Which Start With Number
        // listOfStrings.stream().filter(str -> Character.isDigit(str.charAt(0))).forEach(System.out::println);
        List<String> mixed = Arrays.asList("1abc", "abc", "2xy", "xyz");
        System.out.print("22. Start with digit: ");
        mixed.stream().filter(s -> !s.isEmpty() && Character.isDigit(s.charAt(0))).forEach(s -> System.out.print(s + " "));
        System.out.println();

        // 23. Last Element Of An Array / List
        // listOfStrings.stream().skip(listOfStrings.size()-1).findFirst().get();
        String lastElement = listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst().orElse("");
        System.out.println("23. Last element: " + lastElement);

        // 24. Age Of Person In Years
        // LocalDate birthDay = LocalDate.of(1985, 01, 23);
        // LocalDate today = LocalDate.now();
        // ChronoUnit.YEARS.between(birthDay, today);
        LocalDate birthDay = LocalDate.of(1985, 1, 23);
        LocalDate today = LocalDate.now();
        long ageInYears = ChronoUnit.YEARS.between(birthDay, today);
        System.out.println("24. Age in years (birth 1985-01-23): " + ageInYears);

        // 25. Find Duplicate Elements From An Array
        // listOfIntegers.stream().filter(i -> ! set.add(i)).collect(Collectors.toSet());
        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicates = listOfIntegers.stream()
                .filter(i -> !set.add(i))
                .collect(Collectors.toSet());
        System.out.println("25. Duplicate elements: " + duplicates);

        // 26. Fibonacci Series (first 10)
        // Stream.iterate(new int[] {0, 1}, f -> new int[] {f[1], f[0]+f[1]}).limit(10).map(f -> f[0]).forEach(...)
        System.out.print("26. Fibonacci (first 10): ");
        Stream.iterate(new int[] { 0, 1 }, f -> new int[] { f[1], f[0] + f[1] })
                .limit(10)
                .map(f -> f[0])
                .forEach(i -> System.out.print(i + " "));
        System.out.println();

        System.out.println("\n=== Done ===");
    }
}
