# Test 5: TDD — Test-Driven Development

## The Process (Red → Green → Refactor)
```
1. RED:     Write a failing test first (feature doesn't exist yet)
2. GREEN:   Write minimum code to make test pass
3. REFACTOR: Improve code quality without breaking tests
4. Repeat!
```

## Example: TDD for a Calculator
```java
// STEP 1 — RED (Test fails, method doesn't exist)
@Test
void shouldAddTwoNumbers() {
    Calculator calc = new Calculator();
    assertEquals(5, calc.add(2, 3)); // CompileError: add() doesn't exist!
}

// STEP 2 — GREEN (Minimal code to pass)
public int add(int a, int b) { return a + b; }

// STEP 3 — REFACTOR (Nothing to improve here, next test!)
@Test  
void shouldHandleNegativeNumbers() {
    assertEquals(-1, calc.add(-3, 2));
}
```

## Benefits of TDD
- You write ONLY code that is needed (no dead code)
- Tests act as **living documentation** of intent
- 100% test coverage by definition
- Refactoring is safe — tests catch regressions

## Criticism: TDD Slows You Down?
Short-term: Yes (writing tests first feels slow)
Long-term: No (dramatically fewer bugs, less debugging time)
