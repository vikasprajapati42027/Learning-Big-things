# Test 101: Virtual Threads (Project Loom)

High-concurrency without the high memory cost.

## Key Files:
- `VirtualThreadApplication.java`: Shows how to configure a `VirtualThreadPerTaskExecutor`.
- `LoomController.java`: Demonstrates a blocking task that doesn't block OS threads.
- `EXPLANATION.md`: Platform Threads vs Virtual Threads.

## Why use it?
Until now, 1 Request = 1 OS Thread (expensive). With Virtual Threads, you can have 1 million requests running on just a few OS threads. This is the biggest change in Java concurrency history, making Spring Boot apps incredibly efficient.
