# Test 4: JWT Security Filter

## Simple Explanation
The JWT Filter intercepts EVERY request before it reaches any controller.
It reads the token, validates it, and tells Spring Security who the user is.

## The Filter Chain
```
Browser Request
    ↓
JwtFilter.doFilterInternal()  ← Our code
    ↓
UsernamePasswordAuthenticationFilter
    ↓
ExceptionTranslationFilter
    ↓
Controller
```

## Steps in the Filter
1. Read `Authorization` header
2. Extract the JWT (remove "Bearer " prefix)
3. Validate the token signature
4. Extract username + roles from the token
5. Create an `Authentication` object and store in `SecurityContextHolder`

## OncePerRequestFilter
Guarantees this filter runs exactly ONE time per request
(not multiple times if there are forward/include dispatches).
