# Test 12: Custom Property Source

Instead of putting everything in `application.properties`, you can organize your settings into multiple files.

## Steps:
1. Create a file like `custom.properties`.
2. Use `@PropertySource("classpath:custom.properties")` on a `@Configuration` class.
3. Access values using `@Value` as usual.
