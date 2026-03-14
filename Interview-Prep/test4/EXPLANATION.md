# Interview Q4: Immutability

## Why Create Immutable Objects?
1. **Thread-safe by default** — No synchronization needed!
2. **Cacheable** — Safe to cache (won't change unexpectedly)
3. **Secure** — Callers can't modify internal state

## Rules for Immutable Class
1. Mark class as `final` (no subclassing)
2. All fields `private final`
3. No setters
4. **Defensive copies** for mutable fields (List, Map, Date)
5. Return defensive copies from getters

## Famous Immutable Classes in Java
- `String` (most used)
- `Integer`, `Long` (all wrapper types)
- `LocalDate`, `LocalDateTime`
- `BigDecimal`

## Java Record (Automatic Immutability)
```java
record Point(int x, int y) {}
// Compiler auto-generates: final fields, constructor, getters, equals, hashCode
// Point is automatically immutable!
```

## The Defensive Copy Pattern
```java
// BAD: Stores reference — external code can modify internal state!
this.dates = dates;          

// GOOD: Stores a copy
this.dates = new ArrayList<>(dates);

// BETTER: Stores unmodifiable copy
this.dates = List.copyOf(dates);
```
