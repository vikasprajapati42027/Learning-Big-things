# Test 14: Kafka Retry & Dead Letter Topic (DLT)

## Simple Explanation
What if your Consumer fails to process a message? If you just "ACK" it, the data is lost. If you don't ACK it, the partition is blocked.

## The Strategy
1. **Retry Topic**: If a message fails, send it to an `orders_RETRY` topic.
2. **Backoff**: Wait 5 seconds before trying again from the retry topic.
3. **Dead Letter Topic (DLT)**: If it fails 3 times, move it to `orders_DLT`.

## Why DLT?
- The main queue stays fast and clean.
- Developers can look at the DLT later, fix the bug, and **REPLAY** the failed messages into the main queue.

## Spring Kafka Implementation
Use `@RetryableTopic` with `FixedBackOff` or `ExponentialBackOff`.
- `Exponential`: 1s, 2s, 4s, 8s... (gives the downstream service more time to breathe!)
