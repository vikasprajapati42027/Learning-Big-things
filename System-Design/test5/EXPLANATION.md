# Test 5: Rate Limiting — Token Bucket Algorithm

## Simple Explanation
Rate limiting prevents any single user from abusing your API by making too many calls.

## Token Bucket Algorithm (Most Popular)
```
Bucket = 10 tokens, refills at 1 token/second

User makes request → Takes 1 token
Bucket has 10 tokens → Allow request ✅
Bucket has 0 tokens → Reject with 429 Too Many Requests ❌
```

## Algorithms Comparison
| Algorithm | How it works | Smoothness |
|-----------|-------------|-----------|
| **Token Bucket** | Tokens refill at constant rate | Allows bursts |
| **Leaky Bucket** | Requests processed at constant rate | Very smooth |
| **Fixed Window** | Count resets every minute | Burst at window edge |
| **Sliding Window** | Rolling time window | Most accurate |

## In Spring Boot (Bucket4j + Redis)
```java
@GetMapping("/api/data")
public String getData(HttpServletRequest request) {
    String ip = request.getRemoteAddr();
    Bucket bucket = buckets.computeIfAbsent(ip, k ->
        Bucket.builder()
            .addLimit(Bandwidth.classic(100, Refill.greedy(100, Duration.ofMinutes(1))))
            .build());
    if (bucket.tryConsume(1)) {
        return "Data";
    }
    throw new ResponseStatusException(HttpStatus.TOO_MANY_REQUESTS);
}
```

## HTTP Response for Rate Limit
```
HTTP 429 Too Many Requests
Retry-After: 60
X-RateLimit-Limit: 100
X-RateLimit-Remaining: 0
```
