# Test 24: Scheduling Tasks (@Scheduled)

Automate your background jobs.

## Common Options:
- **`fixedRate`**: Executes every N ms from the *start* of the last execution.
- **`fixedDelay`**: Executes every N ms from the *end* of the last execution.
- **`cron`**: Professional timing (e.g., "Every Friday at midnight").

## Requirements:
- The method should have a `void` return type.
- The method should not accept any arguments.
- Use `@EnableScheduling` in your main class.
