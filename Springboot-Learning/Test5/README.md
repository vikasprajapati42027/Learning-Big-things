# Test 5: External Configuration (@Value & @ConfigurationProperties)

This module explains how to manage your application settings without hardcoding them in Java.

## 1. Why Externalize Configuration?
Hardcoding values like database URLs, API keys, or timeouts is dangerous because:
- You need to recompile the app just to change a setting.
- Sensitive data might be committed to Git.
- Different environments (Dev, QA, Prod) need different values.

## 2. Injected Single Values (`@Value`)
Spring can inject a specific property directly into a field.
- **Syntax**: `@Value("${property.name}")`
- **Default Values**: `@Value("${property.name:default_value}")`

## 3. Grouped Configuration (`@ConfigurationProperties`)
When you have many related properties (like mail settings or database config), `@Value` becomes messy. `@ConfigurationProperties` is better because:
- It's **Type-Safe**: You can use `int`, `boolean`, or even nested objects.
- It's **Grouped**: Maps properties starting with a prefix (e.g., `mail.*`) to a specific class.
- **Requirement**: You must provide Getter and Setter methods.

## Comparison Table

| Feature | `@Value` | `@ConfigurationProperties` |
| :--- | :--- | :--- |
| **Best for** | Single isolated values | Large groups of settings |
| **Type Safety** | No (String based) | Yes (Type validation) |
| **Prefix Support** | No | Yes |
| **Syntax** | Expression based | Prefix based |

## How it works in this code:
1. `application.properties` contains our settings.
2. `ConfigService` uses `@Value` to pull the app name and version.
3. `MailConfig` uses `@ConfigurationProperties(prefix = "mail")` to pull all mail settings at once.
4. `Main` prints both to show they were injected correctly.
