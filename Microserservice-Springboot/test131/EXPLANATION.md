# Test 131: Data Masking (GDPR Compliance)

Protecting sensitive user data from being logged or leaked.

## Key Files:
- `UserProfile.java`: Shows how to use Jackson annotations to prevent sensitive data (like SSN) from being serialized in API responses.
- `EXPLANATION.md`: PI (Personal Information) protection strategies.

## Why use it?
Logging a user's password or bank account number by accident is a huge security risk and illegal under GDPR. Masking ensures that even if you log an object, the secret parts are replaced with `*****` or removed entirely.
