# Java 8 – Lambda (test1) – Interview Q&A

## Q1: What is a Lambda in Java 8?

**Answer:** A lambda is a short way to write an anonymous function (a piece of code you can pass around).  
Instead of writing a full anonymous class with one method, you write a short expression.

- **Before (anonymous class):**  
  `Runnable r = new Runnable() { public void run() { System.out.println("hi"); } };`
- **After (lambda):**  
  `Runnable r = () -> System.out.println("hi");`

**Explanation:** `()` means no arguments, `->` separates parameters from body, and the body is the code that runs.

---

## Q2: How do you convert a Stream to a List?

**Answer:** Use `stream.collect(Collectors.toList())`.

**Code:**
```java
Stream<String> stream = Stream.of("apple", "banana", "cherry");
List<String> collected = stream.collect(Collectors.toList());
```

**Explanation:** A **Stream** is a sequence of items. **Collectors.toList()** is a “collector” that says “put all items into a new List”. So `collect(Collectors.toList())` means “take every element from the stream and add it to a List, then return that List”.

---

## Q3: What does `(x) -> x * 2` mean?

**Answer:** It’s a lambda that takes one argument `x` and returns `x * 2`.

**Code:**
```java
List<Integer> numbers = Stream.of(1, 2, 3)
        .map(x -> x * 2)
        .collect(Collectors.toList());
// numbers = [2, 4, 6]
```

**Explanation:**  
- `map` applies a function to each element.  
- `x -> x * 2` is that function: “given x, return x * 2”.  
So each number in the stream is doubled, then collected into a list.

---

## Q4: How do you filter a Stream with a condition?

**Answer:** Use `.filter(condition)`. Only elements for which the condition is true stay in the stream.

**Code:**
```java
List<Integer> evens = Stream.of(1, 2, 3, 4, 5)
        .filter(n -> n % 2 == 0)
        .collect(Collectors.toList());
// evens = [2, 4]
```

**Explanation:**  
- `filter(n -> n % 2 == 0)` keeps only numbers that are even.  
- The lambda `n -> n % 2 == 0` is a “predicate”: it returns true or false.  
- Then `collect(Collectors.toList())` puts those filtered elements into a List.

---

## Q5: What is Collectors.toList()?

**Answer:** It’s a **Collector** that tells the stream how to gather its elements into a single **List**.

**Code:**
```java
List<String> asList = stream.collect(Collectors.toList());
```

**Explanation:**  
- A **Collector** describes “how to combine stream elements into one result”.  
- **Collectors.toList()** means “combine them into a new ArrayList”.  
- So `stream.collect(Collectors.toList())` means: “run the stream and put every element into a List, then return that List”.

---

## How to run

From project root:

```bash
javac java_version/Java8-version/lambda/test1/Main.java
java -cp . java_version.Java8_version.lambda.test1.Main
```

Expected output includes:  
Lambda: hi  
Collected list: [apple, banana, cherry]  
Doubled: [2, 4, 6]  
Evens: [2, 4]  
As list: [one, two, three]
