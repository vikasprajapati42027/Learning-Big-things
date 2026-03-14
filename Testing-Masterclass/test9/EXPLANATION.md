# Test 9: Mutation Testing (PIT)

## What is Mutation Testing?
Code coverage tells you if tests RUN the code.
Mutation testing tells you if tests actually VERIFY the code.

## How it Works
```
Original code:
  if (age >= 18) return "Adult";

Mutation:
  if (age > 18) return "Adult";   ← Changed >= to >
```
If your test doesn't catch this change → your test is weak!

## PIT (PITest) in Spring Boot
```xml
<plugin>
    <groupId>org.pitest</groupId>
    <artifactId>pitest-maven</artifactId>
    <configuration>
        <targetClasses>com.example.*</targetClasses>
        <mutators>ALL</mutators>
    </configuration>
</plugin>
```
```bash
mvn test-compile org.pitest:pitest-maven:mutationCoverage
```

## Mutation Score
- 80%+ = Good test suite
- 60-80% = Could be better
- < 60% = Tests are just for show!

## Common Mutations PIT Applies
- Change `>` to `>=` (Conditionals)
- Replace `+` with `-` (Math operators)
- Delete method calls (`void` methods)
- Negate returns (`return true` → `return false`)
