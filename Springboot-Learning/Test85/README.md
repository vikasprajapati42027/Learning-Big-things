# Test 85: Event Sourcing

Don't lose history!

## Why use it?
1. **Audit Trail**: You see exactly how the current state was reached.
2. **Time Travel**: You can calculate the state of the app at any point in the past.
3. **Analytics**: Analyze past behaviors (e.g., "Why did users cancel orders 2 years ago?").

## Drawback:
Complexity. Reading the current state requires reading many events. You usually need **Snapshots** to optimize speed.
