# Test 96: OAuth2 Resource Server

Protecting your data globally.

## JWT Validation:
The Resource Server doesn't need to call the Auth Server for every request. It only needs the **Public Key** from the Auth Server to verify that the JWT is authentic. This makes it extremely fast and scalable!

## Scopes:
You can restrict access based on "Scopes" inside the token:
- `SCOPE_read`: Can only see data.
- `SCOPE_write`: Can change data.
Spring Security maps these to `hasAuthority("SCOPE_read")`.
