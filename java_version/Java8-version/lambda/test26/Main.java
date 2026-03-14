package java_version.Java8_version.lambda.test26;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Java 8 Interview Questions – Hirist style
 * "Write a Java 8 program to ..." with full solutions.
 * Ref: https://www.hirist.tech/blog/top-30-java-8-interview-questions-with-answers/
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("=== Java 8 Interview Questions (test26) ===\n");

        question26_RemoveDuplicates();
        question27_PartitionByLength();
        question28_SecondHighest();
        question29_StringsToUppercase();
        question30_FilterEvenNumbers();
        question31_SumOfList();
        question32_AverageLengthOfStrings();
        question33_PalindromeCheck();
        question34_FilterStringsStartingWithA();
        question35_SumOfEvenNumbers();
    }

    // 26. Write a Java 8 program to remove duplicates from a list of integers.
    static void question26_RemoveDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5, 5, 6);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("26. Distinct numbers: " + distinctNumbers);
    }

    // 27. Write a Java 8 program to partition a list of strings into two lists based on their length (greater than 3 characters).
    static void question27_PartitionByLength() {
        List<String> strings = Arrays.asList("Java", "Go", "Python", "C", "Ruby");
        Map<Boolean, List<String>> partitioned = strings.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println("27. Strings with length > 3: " + partitioned.get(true));
        System.out.println("   Strings with length <= 3: " + partitioned.get(false));
    }

    // 28. Write a Java 8 program to find the second highest number in a list of integers.
    static void question28_SecondHighest() {
        List<Integer> numbers = Arrays.asList(3, 9, 1, 4, 8, 6);
        Optional<Integer> secondHighest = numbers.stream()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst();
        System.out.println("28. Second highest number: " + secondHighest.orElse(null));
    }

    // 29. Write a Java 8 program to convert a list of strings to uppercase.
    static void question29_StringsToUppercase() {
        List<String> strings = Arrays.asList("java", "python", "c++", "javascript");
        List<String> uppercaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("29. Uppercase strings: " + uppercaseStrings);
    }

    // 30. Write a Java 8 program to filter out the even numbers from a list of integers.
    static void question30_FilterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.print("30. Even numbers: ");
        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

    // 31. Write a Java 8 program to find the sum of all elements in a list of integers.
    static void question31_SumOfList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("31. Sum: " + sum);
    }

    // 32. Write a Java 8 program to find the average length of strings in a list of strings.
    static void question32_AverageLengthOfStrings() {
        List<String> strings = Arrays.asList("Java", "Python", "C++", "JavaScript", "Ruby");
        OptionalDouble averageLength = strings.stream()
                .mapToInt(String::length)
                .average();
        System.out.println("32. Average length of strings: " + (averageLength.isPresent() ? averageLength.getAsDouble() : 0));
    }

    // 33. Write a Java 8 program to check if a given string is a palindrome or not.
    static void question33_PalindromeCheck() {
        String str = "madam";
        boolean isPalindrome = IntStream.range(0, str.length() / 2)
                .noneMatch(i -> str.charAt(i) != str.charAt(str.length() - i - 1));
        System.out.println("33. Is Palindrome '" + str + "': " + isPalindrome);
    }

    // 34. You have a list of strings. How would you filter out the strings that start with the letter 'A'?
    static void question34_FilterStringsStartingWithA() {
        List<String> strings = Arrays.asList("Apple", "Banana", "Apricot", "Orange");
        List<String> filteredStrings = strings.stream()
                .filter(s -> s.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("34. Strings starting with 'A': " + filteredStrings);
    }

    // 35. You have a list of integers. How would you find the sum of all even numbers in the list?
    static void question35_SumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sumOfEvenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("35. Sum of even numbers: " + sumOfEvenNumbers);
    }
}
