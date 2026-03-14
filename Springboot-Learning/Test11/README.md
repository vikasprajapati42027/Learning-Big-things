# Test 11: Spring Boot Profiles

Profiles are a core feature of Spring that allow you to map beans to different environments.

## How to use:
1. Use `@Profile("name")` on a class.
2. Activate the profile in `application.properties`: 
   `spring.profiles.active=dev`
3. Or pass it as a command-line argument:
   `--spring.profiles.active=prod`

In this example:
- `DevService` is only created if the `dev` profile is active.
- `ProdService` is only created if the `prod` profile is active.
