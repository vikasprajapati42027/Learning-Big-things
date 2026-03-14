# Test 15: Custom Filter Chain

## Simple Explanation
Spring Security works like an **Assembly Line** (the Filter Chain). Every request passes through many filters. You can add your own custom worker to this line!

## Common Filter Positions
- `addFilterBefore(custom, Standard.class)`: Runs YOUR filter first.
- `addFilterAfter(custom, Standard.class)`: Runs YOUR filter after standard logic.
- `addFilterAt(custom, Standard.class)`: Replaces/shares the position (careful!).

## Example Use Case: API Keys
If you want to check for a custom header like `X-API-KEY` before Spring even tries to check for a username/password, you add a filter at the very beginning of the chain.

## The `chain.doFilter()` call
This is the most important line! It passes the request to the **NEXT** person in line. If you forget this, the request STOPS and the user gets a blank page or an error.
