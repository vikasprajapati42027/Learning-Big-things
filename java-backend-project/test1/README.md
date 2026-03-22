# URL Shortener (Spring Boot)

Path: `java-backend-project/test1`

## Features
- Generate short URL (`POST /api/v1/urls/shorten`)
- Redirect (`GET /api/v1/urls/{code}`)
- Analytics (`GET /api/v1/urls/{code}/stats`)
- Caching with Caffeine (code → UrlMapping)
- JPA/H2 (swap to MySQL/Postgres easily)

## Run
```bash
cd java-backend-project/test1
mvn spring-boot:run
# or build
mvn clean package
java -jar target/url-shortener-0.1.0.jar
```

## API samples
- Shorten:
  ```bash
  curl -X POST http://localhost:8080/api/v1/urls/shorten \
    -H "Content-Type: application/json" \
    -d '{"url":"https://example.com/long"}'
  ```
- Redirect:
  `GET http://localhost:8080/{code}`
- Stats:
  `GET http://localhost:8080/api/v1/urls/{code}/stats`

## Notes / Extensions
- Swap H2 for MySQL: change `application.yml` datasource.
- Add Redis cache: replace Caffeine with `spring-boot-starter-data-redis`.
- Add rate limiting (Bucket4j), and background compaction for stale links.
- For sharding/high traffic: move persistence to separate service, use base62 IDs with Snowflake/KSUID, add CDN edge redirects.
