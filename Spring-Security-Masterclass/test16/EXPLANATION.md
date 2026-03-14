# Test 16: Method Security (@PreAuthorize)

## Simple Explanation
Configuration inside the `SecurityFilterChain` is good for URL-level security (e.g., `/admin/**`). But sometimes you need security on a specific **Method** or based on the **Parameters**.

## How it works
You use `@PreAuthorize` on top of your controller or service methods. Spring uses AOP (Proxies) to check the security rule BEFORE the method even starts.

## Common Expressions (SpEL)
- `hasRole('ADMIN')`: User must have ROLE_ADMIN.
- `hasAnyAuthority('READ', 'WRITE')`: Check specific permissions.
- `isAuthenticated()`: Just check if they are logged in.
- `#username == authentication.name`: Check if the user is trying to access their OWN record.

## Setup
You must add `@EnableMethodSecurity` to a `@Configuration` class.

## Why use it?
It's much more flexible than URL-based security and puts the security rule right next to the code it protects.
