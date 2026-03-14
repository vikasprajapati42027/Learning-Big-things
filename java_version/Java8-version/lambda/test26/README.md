# test26 – Java 8 Interview Questions (Hirist style)

Questions in the format: **"Write a Java 8 program to ..."** with full runnable solutions.

Reference: [Top 40+ Java 8 Interview Questions With Answers – Hirist](https://www.hirist.tech/blog/top-30-java-8-interview-questions-with-answers/)

---

## Questions

26. **Write a Java 8 program to remove duplicates from a list of integers.**  
    `stream().distinct().collect(Collectors.toList())`

27. **Write a Java 8 program to partition a list of strings into two lists based on their length (greater than 3 characters).**  
    `Collectors.partitioningBy(s -> s.length() > 3)`

28. **Write a Java 8 program to find the second highest number in a list of integers.**  
    `sorted((a,b) -> b-a).skip(1).findFirst()`

29. **Write a Java 8 program to convert a list of strings to uppercase.**  
    `map(String::toUpperCase).collect(Collectors.toList())`

30. **Write a Java 8 program to filter out the even numbers from a list of integers.**  
    `filter(n -> n % 2 == 0).forEach(...)`

31. **Write a Java 8 program to find the sum of all elements in a list of integers.**  
    `mapToInt(Integer::intValue).sum()`

32. **Write a Java 8 program to find the average length of strings in a list of strings.**  
    `mapToInt(String::length).average()`

33. **Write a Java 8 program to check if a given string is a palindrome or not.**  
    `IntStream.range(0, str.length()/2).noneMatch(i -> str.charAt(i) != str.charAt(str.length()-i-1))`

34. **You have a list of strings. How would you filter out the strings that start with the letter 'A'?**  
    `filter(s -> s.startsWith("A")).collect(Collectors.toList())`

35. **You have a list of integers. How would you find the sum of all even numbers in the list?**  
    `filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum()`

---

## Run

```bash
javac java_version/Java8-version/lambda/test26/Main.java
java -cp . java_version.Java8_version.lambda.test26.Main
```
