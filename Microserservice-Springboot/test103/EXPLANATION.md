# Test 103: API Data Compression (Gzip)

Reducing network bandwidth by compressing large JSON responses.

## Key Files:
- `application.properties`: Configuration to enable Gzip compression.
- `EXPLANATION.md`: Speed vs CPU tradeoffs.

## Concept:
Setting `server.compression.enabled=true` tells Spring Boot to zip the data before sending it. On a slow mobile connection, this can make your app feel 5x faster because it's downloading much less data.
