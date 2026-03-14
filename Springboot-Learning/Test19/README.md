# Test 19: Method Level Security

Fine-grained control directly on your code!

## Annotations:
- **`@EnableMethodSecurity`**: Enables this feature in your config.
- **`@PreAuthorize`**: Checks security **before** the method runs.
- **`@PostAuthorize`**: Checks security **after** the method runs (can check the return value).
- **`@Secured`**: Older annotation for basic role checks.

## SpEL (Spring Expression Language):
You can use complex logic:
`@PreAuthorize("#id == authentication.principal.id")` (Checks if the user is fetching their OWN data).
