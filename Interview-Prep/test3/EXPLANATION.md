# Interview Q3: Exception Handling

## Checked vs Unchecked
| Type | Examples | Must handle? |
|------|----------|-------------|
| **Checked** | IOException, SQLException | YES — compiler forces you |
| **Unchecked** | NullPointerException, IllegalArgumentException | NO — optional |

## Interview: "When to use Checked vs Unchecked?"
- **Checked**: Recoverable situations (file not found → ask user to choose another)
- **Unchecked/RuntimeException**: Programming errors (null pointer, invalid args)

## Common Mistakes
```java
// ❌ Swallowing exceptions
try { doWork(); } catch (Exception e) {} // NEVER do this! Bug is now hidden.

// ❌ Catching Exception broadly
catch (Exception e) { ... } // Catches OutOfMemoryError too!

// ✅ Correct pattern
catch (SpecificException e) {
    log.error("Failed: " + e.getMessage(), e); // Log the full stack trace!
    throw new ApplicationException("User-friendly message", e); // Wrap, keep cause
}
```

## Spring's @ExceptionHandler
```java
@ExceptionHandler(PaymentFailedException.class)
public ResponseEntity<ErrorResponse> handlePayment(PaymentFailedException ex) {
    return ResponseEntity.status(402).body(new ErrorResponse(ex.getMessage()));
}
```
