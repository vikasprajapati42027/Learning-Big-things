# Test 52: Spring Batch (Chunk Processing)

Efficiency meets Reliability.

## How it works:
1. **Read**: The reader fetches one item.
2. **Process**: The processor transforms it.
3. This repeats until the **Chunk Size** (e.g., 100) is reached.
4. **Write**: The writer saves all 100 items at once in a single transaction.

## Benefit:
If record #99 fails, the whole chunk of 100 is rolled back. Your database stays clean!
