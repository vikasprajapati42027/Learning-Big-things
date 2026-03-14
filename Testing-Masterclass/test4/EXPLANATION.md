# Test 4: TestContainers — Real Services in Tests

## The Problem with H2
H2 is a fake database — some PostgreSQL features don't work in H2.
Your query works in tests but fails in production!

## Solution: TestContainers
Spin up a REAL PostgreSQL Docker container just for the test.
Test against the exact same database as production!

## Example
```java
@SpringBootTest
@Testcontainers
class UserServiceIT {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:15")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @Test
    void testUserCreation() {
        // This test runs against a REAL PostgreSQL container!
    }
}
```

## TestContainers Can Run
- PostgreSQL, MySQL, MongoDB
- Redis, Kafka, RabbitMQ
- Elasticsearch, Cassandra
- Any Docker image
