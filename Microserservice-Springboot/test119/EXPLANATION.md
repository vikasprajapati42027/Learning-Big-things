# Test 119: Spring Application Events

Decoupling business actions from their side effects.

## Key Files:
- `WelcomeEmailListener.java`: Shows publishing a `UserCreatedEvent` and listening to it.
- `EXPLANATION.md`: Events keep your services loosely coupled.

## Concept:
Without events, `UserService` must directly call `EmailService`, `NotificationService`, and `AuditService`. With events, `UserService` just publishes "UserCreated" and completely forgets about it. Each handler reacts independently — no coupling, no dependencies.
