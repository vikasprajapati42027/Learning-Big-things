# Test 33: AOP @Around Advice

The most powerful advice type.

## Capabilities:
- Run code before the method.
- Run code after the method.
- Catch/Handle exceptions.
- **Modify the return value**.
- Decide whether to execute the method at all (e.g., for caching).

## ProceedingJoinPoint:
You MUST call `joinPoint.proceed()` to run the target method. If you don't, the method never executes!
