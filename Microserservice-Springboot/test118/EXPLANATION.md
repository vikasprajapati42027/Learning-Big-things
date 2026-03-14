# Test 118: Global Exception Handling

Returning clean, consistent error responses for every failure type.

## Key Files:
- `GlobalExceptionHandler.java`: `@RestControllerAdvice` catches exceptions from ALL controllers.
- `EXPLANATION.md`: Why try-catch in controllers is anti-pattern.

## Concept:
Instead of `try-catch` in every controller method, you define handlers ONCE in one class. When any controller throws a `NotFoundException`, Spring automatically finds the right handler and returns a clean JSON error. One class, zero duplication.
