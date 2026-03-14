# Interview Q5: Thread Safety

## Performance Comparison (Fastest to Slowest)
1. **Atomic (AtomicInteger)** — CPU instruction, no waiting
2. **ReadWriteLock** — Concurrent reads! Slow only for writes  
3. **ReentrantLock** — Flexible locking with tryLock, timeout
4. **synchronized** — Simple but locks whole object

## Interview: "What is deadlock?"
```
Thread A holds Lock 1, waiting for Lock 2
Thread B holds Lock 2, waiting for Lock 1
   → Both wait forever = DEADLOCK!
```
Prevention: Always acquire locks in the SAME ORDER in every thread.

## Interview: "volatile vs synchronized"
- `volatile` → Ensures visibility (latest value seen by all threads), NOT atomic for `++`
- `synchronized` → Ensures visibility + atomicity + mutual exclusion

## interview: "What is a race condition?"
Two threads read-modify-write the same variable without synchronization:
```
Thread 1: reads count=5
Thread 2: reads count=5
Thread 1: writes count=6
Thread 2: writes count=6  ← Should be 7! One increment lost!
```
