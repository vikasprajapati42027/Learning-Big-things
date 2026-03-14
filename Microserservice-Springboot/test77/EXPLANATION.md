# Test 77: @RefreshScope

Updating application properties at runtime without a restart.

## Key Files:
- `ConfigRefreshApplication.java`: Demonstrates the `@RefreshScope` annotation.
- `EXPLANATION.md`: Why Spring context needs to be re-initialized.

## Concept:
By default, Spring injects `@Value` properties during startup. If you change them later, the app won't see the change. `@RefreshScope` creates a proxy around the bean so that when the config changes, Spring can destroy and recreate the bean with the new values live!
