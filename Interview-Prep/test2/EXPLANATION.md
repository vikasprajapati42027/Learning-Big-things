# Interview Q2: HashMap Internal Working

## The Storage Structure
```
HashMap = Array of "Buckets" (default 16 buckets)
Each bucket = LinkedList (or Red-Black Tree for > 8 entries)
```

## put("key", value) — Step by Step
```
1. hash = "key".hashCode()
2. index = hash & (capacity - 1)   ← Which bucket?
3. If bucket empty → store entry
4. If bucket has entries:
   - Compare key.equals() for each entry
   - If match found → UPDATE value
   - If no match → APPEND to LinkedList (collision!)
```

## get("key") — Step by Step
```
1. hash = "key".hashCode()
2. index = hash & (capacity - 1)   ← Same bucket
3. Walk the list, compare key.equals()
4. Return matching value (or null)
```

## Why Override Both equals() AND hashCode()?
```java
Person p1 = new Person("Vikas");
Person p2 = new Person("Vikas");

// Without override: p1.hashCode() != p2.hashCode() → different buckets!
// get(p2) returns null even though logically p1 equals p2!
```

## Common Interview Question: "When does HashMap resize?"
When entries exceed `capacity * loadFactor` (default: 16 * 0.75 = 12),
HashMap resizes to 32 buckets and REHASHES all entries.
