# Test 25: Caching (@Cacheable)

Make your app lightning fast!

## How it works:
When a method is called with `@Cacheable`, Spring looks in the cache. 
- If found, it returns the stored result.
- If not found, it runs the method and keeps the result for next time.

## Other annotations:
- **`@CacheEvict`**: Removes entries from the cache (e.g., when data is updated).
- **`@CachePut`**: Updates the cache without stopping method execution.

## Backends:
By default, Spring uses a simple `ConcurrentHashMap`. In production, you would use **Redis** or **Ehcache**.
