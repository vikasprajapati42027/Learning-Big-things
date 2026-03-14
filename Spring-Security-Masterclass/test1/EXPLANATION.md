# Test 1: Basic Authentication

## Simple Explanation
When a user tries to access a protected URL, the browser shows a popup asking for username and password.
Spring Security validates it against your `UserDetailsService`.

## Components
1. **SecurityFilterChain** → Rules: who can access what URL
2. **UserDetailsService** → Where user data comes from (DB, memory, LDAP)
3. **PasswordEncoder** → How passwords are hashed (BCrypt = industry standard)

## BCrypt — Why it's special
- Same password hashed twice gives **different results** (because of a random salt)
- Impossible to reverse. Attacker can't get original password from the hash
- `matches("password123", storedHash)` — Spring does this comparison for you

## Flow
```
Browser → POST /login → Spring Security checks credentials
   ↓
UserDetailsService.loadUserByUsername("vikas")
   ↓ 
BCryptPasswordEncoder.matches("password123", hash)
   ↓
If match → Session created + redirect to app
```
