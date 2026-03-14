# Test 99: Conditional Annotations

The "If" statements of Spring Configuration.

## Power of Conditions:
They allow Spring to make decisions at **Runtime** based on:
- Environment variables.
- Presence of JARs in the classpath.
- Configuration properties.

This is why, when you add the "H2" jar, Spring Boot *automatically* sets up a DataSource for you! It uses `@ConditionalOnClass(DataSource.class)`.
