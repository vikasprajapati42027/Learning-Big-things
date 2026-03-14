# Test 82: Async Processing (@Async)

Offloading slow tasks to a background thread without blocking the user.

## Key Files:
- `AsyncEmailService.java`: Uses `@Async` to run email sending in a separate thread.
- `AsyncController.java`: Returns a response to the user instantly while email sends in background.
- `EXPLANATION.md`: Fire-and-forget for slow I/O tasks.

## Concept:
Without `@Async`, users wait 3 seconds for the email to send before seeing any response. With `@Async`, the controller returns "Email is being sent" immediately. The email finishes in a background thread while the user is already reading the success message.
