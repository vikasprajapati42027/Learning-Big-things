# Test 98: Custom Auto-Configuration

Build your own Spring Boot Starters.

## How it works:
1. Create a library.
2. Define a `@Configuration` class.
3. List the class in `src/main/resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`.
4. Add **Conditions** so it only runs when needed.

This allows you to share "Best Practice" configurations across all teams in your company effortlessly!
