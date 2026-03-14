# Test 130: @ConfigurationProperties

Binding a group of related config values to a structured Java class.

## Key Files:
- `EmailProperties.java`: A typed configuration class bound to the `app.email.*` prefix.
- `application.properties`: The actual values.
- `EXPLANATION.md`: Why typed config is better than `@Value`.

## Concept:
Using `@Value("${app.email.host}")` for every field is messy. `@ConfigurationProperties` binds all `app.email.*` properties into one clean `EmailProperties` object automatically. You also get IDE auto-complete and validation for free!
