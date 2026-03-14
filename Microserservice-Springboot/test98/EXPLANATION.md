# Test 98: Custom Auto-Configuration

Creating your own "Spring Boot Starter" libraries.

## Key Files:
- `MyCustomAutoConfiguration.java`: Demonstrates the `@ConditionalOnMissingBean` magic.
- `EXPLANATION.md`: How Spring Boot "guesses" what you need.

## Why use it?
If you have 100 microservices, you don't want to copy-paste the same logging config 100 times. You create a "Starter" library. When a dev adds it to their `pom.xml`, Spring automatically configures it for them.
