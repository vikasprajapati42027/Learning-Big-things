# Test 115: Bean Validation (Jakarta Validation)

Rejecting bad input data before it ever reaches your business logic.

## Key Files:
- `ValidationController.java`: Full example with `@NotBlank`, `@Email`, `@Size`, `@Min`.
- `EXPLANATION.md`: Client never sends valid data — always validate on the server!

## Concept:
`@Valid` on a `@RequestBody` triggers automatic validation of all annotations on the class. If any rule fails, Spring returns a 400 Bad Request with a clear error message — no if-statements or manual checks needed in your service layer.
