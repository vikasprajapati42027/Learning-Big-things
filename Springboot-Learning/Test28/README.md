# Test 28: Spring Events

Loose coupling is a sign of a good architecture.

## Why use Events?
Imagine a User Registration. You need to:
1. Save user.
2. Send email.
3. Notify analytics.
4. Generate a promo code.

Instead of putting all this code in one big `RegisterService`, you just publish `UserRegisteredEvent`, and 4 different listeners handle the rest!

## Async Listeners:
Use `@Async` on top of `@EventListener` to run them in the background.
