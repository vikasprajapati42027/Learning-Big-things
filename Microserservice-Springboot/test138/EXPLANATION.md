# Test 138: Standardized API Responses

Every endpoint returns the same consistent envelope structure.

## Key Files:
- `StandardResponseController.java`: Uses a generic `ApiResponse<T>` wrapper for all responses.
- `EXPLANATION.md`: Why inconsistent responses break client apps.

## Concept:
Without a standard, one endpoint returns `{name: "Vikas"}` and another returns `{user: {name: "Vikas"}}`. Clients have to handle every shape differently. A standard wrapper — `{success, message, data}` — means clients always parse the response the same way.
