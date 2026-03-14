# Test 6: Design a URL Shortener (bit.ly)

## Requirements
- User enters: `https://verylongurl.com/page/with/path?query=value`
- Gets back: `https://bit.ly/Ab3Xy`
- When someone visits `bit.ly/Ab3Xy` → Redirect to original URL

## Step 1: Generate Short Code
```java
// Approach 1: Random (simple)
String code = RandomStringUtils.randomAlphanumeric(6); // e.g., "Ab3Xy7"

// Approach 2: Base62 encode auto-increment ID (better)
// ID 100 → "1C"  (using chars 0-9, a-z, A-Z = 62 characters)
```

## Step 2: Store Mapping
```sql
CREATE TABLE urls (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    short_code VARCHAR(10) UNIQUE,
    original_url TEXT,
    created_at TIMESTAMP,
    expires_at TIMESTAMP
);
```

## Step 3: Redirect
```java
@GetMapping("/{code}")
public ResponseEntity<Void> redirect(@PathVariable String code) {
    String url = urlService.getOriginalUrl(code); // Check Redis first!
    return ResponseEntity.status(301).header("Location", url).build();
}
```

## Scaling Considerations
| Challenge | Solution |
|-----------|---------|
| 10B URLs to store | Database sharding by short_code |
| High read traffic | Redis cache (most URLs are read >100x) |
| Short code collisions | Check if exists before saving |
| Analytics (click count) | Kafka + async counter updates |
