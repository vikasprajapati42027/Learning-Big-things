# Test 3: Role-Based Authorization (RBAC)

## Simple Explanation
Authentication = "WHO are you?" (Login)
Authorization = "WHAT can you do?" (Permissions)

## Roles vs Authorities
| Concept | Example | Spring prefix |
|---------|---------|--------------|
| **Role** | ADMIN, USER, MANAGER | Stored as `ROLE_ADMIN` in DB |
| **Authority** | READ_ORDERS, DELETE_USERS | Fine-grained permission |

## @PreAuthorize vs @Secured
```java
@PreAuthorize("hasRole('ADMIN')")        // Flexible — supports SpEL
@Secured("ROLE_ADMIN")                   // Simple, but less powerful
@PostAuthorize("returnObject.owner == authentication.name")  // Check AFTER method runs
```

## Enable Method Security
```java
@Configuration
@EnableMethodSecurity  // MUST add this for @PreAuthorize to work!
class SecurityConfig { ... }
```

## SecurityContextHolder
This is Spring's container for the currently logged-in user.
You can read it anywhere in your code — it's thread-local (one per request).
