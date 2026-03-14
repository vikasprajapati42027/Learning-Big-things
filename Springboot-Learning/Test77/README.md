# Test 77: Secret Management (Vault)

Never put clear-text passwords in `application.properties`.

## Why use Vault?
- **Security**: Passwords are encrypted at rest.
- **Dynamic Secrets**: Vault can generate a temporary DB password that expires after 1 hour!
- **Auditing**: You can see exactly WHO accessed a password and WHEN.
- **Centralization**: All your microservices fetch secrets from one secure place.
