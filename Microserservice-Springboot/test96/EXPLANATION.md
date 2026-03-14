# Test 96: Redis Distributed Caching

Sharing a cache across multiple instances of a service.

## Key Files:
- `DistributedCacheService.java`: Shows the `@Cacheable` annotation.
- `EXPLANATION.md`: Why local cache is bad for microservices.

## Why use it?
If you have 10 instances of "Product-Service", and one instance fetches a product, you want ALL 10 instances to have that data in their cache. Redis acts as a shared brain for all your service instances.
