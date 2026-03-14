# Test 129: Bean Scopes (Singleton vs Prototype)

Controlling how many instances of your beans Spring creates.

## Key Files:
- `BeanScopeConfig.java`: Shows `SCOPE_SINGLETON` (one shared instance) and `SCOPE_PROTOTYPE` (new per injection).
- `EXPLANATION.md`: Why the default Singleton scope causes thread-safety bugs.

## Scopes:
| Scope | Description |
|-------|-------------|
| `singleton` | One instance for the whole app (default) |
| `prototype` | New instance every time it's injected |
| `request` | New instance per HTTP request (web) |
| `session` | New instance per user session (web) |
