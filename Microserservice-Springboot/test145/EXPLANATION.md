# Test 145: Spring Cache Annotations Deep Dive

All three caching annotations working together.

## Key Files:
- `EmployeeCacheService.java`: Shows `@Cacheable`, `@CacheEvict`, and `@CachePut` in one class.
- `EXPLANATION.md`: The full cache lifecycle.

## Annotations:
| Annotation | Purpose |
|------------|---------|
| `@Cacheable` | Cache the return value (on reads) |
| `@CacheEvict` | Remove entry from cache (on deletes) |
| `@CachePut` | Update the cache with new value (on updates) |

This ensures your cache is always in sync with your database!
