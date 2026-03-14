# Java 8 Lambda & Stream – Basic to Advanced (test4)

## BASIC

| Q | Question | Answer / Code |
|---|----------|----------------|
| 1 | Lambda syntax with one parameter? | `(param) -> expression` or `param -> expression` |
| 2 | How to filter? | `.filter(n -> n % 2 == 0)` — keeps only where condition is true |
| 3 | What does map() do? | Transforms each element: `map(n -> n * 2)` |
| 4 | map vs flatMap? | map = 1-to-1. flatMap = 1-to-many then flatten |
| 5 | First element of Stream? | `.findFirst()` returns `Optional<T>`; use `.orElse(default)` |
| 6 | What does reduce do? | Combines all into one: `reduce(0, Integer::sum)` |
| 7 | Remove duplicates? | `.distinct()` |
| 8 | Sort a Stream? | `.sorted()` or `.sorted(Comparator.reverseOrder())` |
| 9 | limit and skip? | `limit(n)` = first n; `skip(n)` = drop first n |
| 10 | What is Optional? | Wraps value that may be absent; use `orElse()`, `ifPresent()` |

## INTERMEDIATE

| Q | Question | Answer / Code |
|---|----------|----------------|
| 11 | Group by key? | `Collectors.groupingBy(String::length)` → Map<Length, List<String>> |
| 12 | Partition (two groups)? | `Collectors.partitioningBy(n -> n % 2 == 0)` → Map<Boolean, List> |
| 13 | Stream to Map? | `Collectors.toMap(keyMapper, valueMapper)` — keys must be unique |
| 14 | Sort by custom field? | `Comparator.comparing(String::length).thenComparing(Function.identity())` |
| 15 | Method reference? | `String::length` = `s -> s.length()`, `System.out::println` = `x -> System.out.println(x)` |
| 16 | Count frequency? | `groupingBy(Function.identity(), Collectors.counting())` |
| 17 | Join with delimiter/prefix/suffix? | `Collectors.joining(", ", "[", "]")` |
| 18 | Max / Min? | `.max(Comparator.naturalOrder())`, `.min(...)` — returns Optional |

## ADVANCED

| Q | Question | Answer / Code |
|---|----------|----------------|
| 19 | Second largest? | `.sorted(Comparator.reverseOrder()).skip(1).findFirst()` |
| 20 | Merge two lists, unique, sorted? | `Stream.concat(a.stream(), b.stream()).distinct().sorted().collect(toList())` |
| 21 | reduce with combiner (parallel)? | `reduce(0, Integer::sum, Integer::sum)` |
| 22 | Unmodifiable list? | `Collectors.toUnmodifiableList()` or `.toList()` (Java 16+) |
| 23 | Find duplicates? | Use Set: `filter(i -> !set.add(i)).collect(Collectors.toSet())` |
| 24 | IntStream to List<Integer>? | `IntStream.range(1,6).boxed().collect(Collectors.toList())` |
| 25 | Fibonacci with Stream? | `Stream.iterate(new int[]{0,1}, f -> new int[]{f[1], f[0]+f[1]}).limit(8).map(f -> f[0])` |

## Run

```bash
javac java_version/Java8-version/lambda/test4/Main.java
java -cp . java_version.Java8_version.lambda.test4.Main
```
