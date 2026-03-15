# JWT Profile Service

Spring Boot service demonstrating JWT-based authentication for a profile endpoint.

## Commands

- `mvn clean package` builds the jar.
- `java -jar target/jwt-profile-service-0.0.1-SNAPSHOT.jar` runs the service on port 9090.

## Endpoints

- `POST /api/login` accepts `{"username":"profile","password":"secure"}` and returns a JWT.
- `GET /api/profile` requires `Authorization: Bearer <token>` and returns profile JSON.

JWT uses HMAC-SHA256 with the secret configured in `application.properties`.
