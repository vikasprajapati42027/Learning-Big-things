# Test 84: Scheduled Tasks (@Scheduled)

Running background jobs at fixed times or intervals.

## Key Files:
- `ScheduledTasks.java`: Demonstrates `fixedRate`, `fixedDelay`, and `cron` expressions.
- `EXPLANATION.md`: When to use scheduled jobs vs message queues.

## Concept:
- `fixedRate`: Runs every N ms (counting from start of previous run).
- `fixedDelay`: Runs N ms after previous run **finishes** (safer for slow tasks).
- `cron`: Full cron expression for complex schedules like "every Tuesday at 3am".
