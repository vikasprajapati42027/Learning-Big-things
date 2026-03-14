# Test 51: Spring Batch (Introduction)

Process data in the background, reliably.

## What is Batch Processing?
Processing data without user interaction.
Example: Generating bank statements at the end of the month for 10 million users.

## Why Spring Batch?
- **Chunking**: Processes data in small groups (chunks) so you don't run out of memory.
- **Restart**: If the server crashes at record 500,000, it can start from there next time.
- **Transaction**: Either the whole chunk is saved, or none of it is.
