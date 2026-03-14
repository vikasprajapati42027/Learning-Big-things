# Test 147: Environment Profiles & Variables

Configuring your app differently for dev, staging, and production.

## Key Files:
- `EnvironmentController.java`: Shows how `@Value` reads from properties AND environment variables.
- `EXPLANATION.md`: The 12-Factor App Config principle.

## Concept:
`@Value("${DB_URL}")` reads from `application.properties` first. But if an OS-level environment variable `DB_URL` exists, it takes priority. This lets Kubernetes inject real database credentials without baking them into code or config files.
