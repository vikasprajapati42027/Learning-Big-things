# Test 94: Profiling Applications

Finding the bottleneck.

## Tools:
1. **VisualVM**: Free tool included in some JDKs. Monitors CPU and Heap usage visually.
2. **JProfiler / YourKit**: Enterprise-grade profilers for deep analysis.
3. **Async Profiler**: Lightweight tool for production environments.

## What to look for:
- **CPU Hotspots**: Methods that take 90% of the time.
- **Memory Leaks**: Memory that grows forever and never gets freed.
- **Thread Locks**: When multiple threads are waiting for each other (Deadlock).
