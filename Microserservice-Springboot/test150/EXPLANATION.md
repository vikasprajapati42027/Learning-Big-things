# Test 150: Performance Profiling (JFR & JMC)

The ultimate tools for finding bugs and leaks in production.

## Key Files:
- `ProfilingController.java`: A simple heavy task for testing.
- `EXPLANATION.md`: Java Flight Recorder (JFR) and Java Mission Control (JMC).

## Why use it?
When your app is slow in production, you can't just guess. JFR is built into the Java Virtual Machine. It records exactly which lines of code are taking the most time and which objects are filling up your memory. It's the "Flight Data Recorder" for your code.
