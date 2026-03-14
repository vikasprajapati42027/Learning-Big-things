# Test 5: Database-Backed Authentication

## Simple Explanation
In test1 we used hard-coded in-memory users. In real apps, users are stored in a database.
We implement `UserDetailsService` to tell Spring Security how to load a user from the DB.

## How Spring Security Uses It
```
POST /login  with  { "username": "vikas", "password": "mypass" }
    ↓
Spring calls: userDetailsService.loadUserByUsername("vikas")
    ↓
You fetch AppUser from DB by username
    ↓
Return UserDetails (with hashed password and roles)
    ↓
Spring compares entered password against hash via BCrypt
    ↓
If match → authenticated! JWT issued.
```

## Important: Never Store Plain Passwords!
When registering a user, ALWAYS hash before saving:
```java
String hashed = passwordEncoder.encode("mypass");
user.setPassword(hashed);
userRepository.save(user);
```
