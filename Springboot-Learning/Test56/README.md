# Test 56: R2DBC (Reactive SQL)

Reactive Database access for SQL.

## Why not JPA?
JPA/JDBC is **Blocking**. If you use JPA in a WebFlux app, you lose the reactive benefits. 

## R2DBC:
It's a newer specification that brings reactive headers to SQL. 
- It returns `Flux` and `Mono`.
- It's non-blocking at the driver level.
- It doesn't support complex things like "Lazy Loading" (because that's naturally blocking).
