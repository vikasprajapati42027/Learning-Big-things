# Test 4: Custom Configuration (@Configuration & @Bean)

This module explains how to register beans manually.

## 1. The Limitation of `@Component`
The `@Component` annotation is great when you can modify the source code. But what if:
- You are using an external library (like a JSON parser or a database driver)?
- You need to create multiple instances of the same class with different settings?
- You need complex logic to initialize an object?

In these cases, you cannot use `@Component`.

## 2. The Solution: `@Configuration` and `@Bean`

### `@Configuration`
- This marks a class as a source of bean definitions.
- It acts like a "Factory" for your application objects.

### `@Bean`
- This is applied to a **method**.
- Spring calls this method and puts the returned object into the IoC Container.
- By default, the bean's ID is the name of the method.

## Comparison: Automatic vs. Manual

| Feature | `@Component` (Automatic) | `@Bean` (Manual) |
| :--- | :--- | :--- |
| **Placement** | On the class itself | On a method inside `@Configuration` |
| **Control** | Minimal | Full control over instantiation |
| **Use Case** | Your own classes | Third-party classes / Complex setup |

## How it works in this code:
1. `MyCustomObject` is a plain Java class (No annotations).
2. `ProjectConfig` is marked with `@Configuration`.
3. Spring sees the `customBean()` method marked with `@Bean`.
4. Spring runs `new MyCustomObject(...)` and stores the instance.
5. In `Main`, Spring finds the bean and injects it via `@Autowired`.
