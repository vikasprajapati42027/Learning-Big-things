# Test 23: Async Execution (@Async)

Don't make your users wait for background tasks!

## How it works:
1. Annotate a class with `@EnableAsync`.
2. Annotate a method with `@Async`.
3. Spring creates a "proxy". When you call the method, it delegates the work to a task executor (thread pool).

## Rules:
- It must be applied to `public` methods.
- Self-invocation (calling the method from within the same class) won't work because it bypasses the proxy.
