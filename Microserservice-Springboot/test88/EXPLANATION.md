# Test 88: Spring Security (Method-Level)

Fine-grained access control directly on individual methods.

## Key Files:
- `SecuredController.java`: Shows `@PreAuthorize` protecting specific endpoints.
- `EXPLANATION.md`: URL vs Method security.

## Concept:
URL security (`/admin/**`) only works at the path level. Method security (`@PreAuthorize`) works at the code level — even internal service calls are protected. It's the "lock on the door" vs "the lock on the safe."
