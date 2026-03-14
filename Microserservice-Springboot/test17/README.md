# Test 17: CQRS (Command Query Responsibility Segregation)

Separating "Writes" and "Reads".

## The Problem:
A "Product" page is visited 1,000,000 times, but the "Product Description" is only updated once a month.
In a normal DB, you use the same server for both.

## The Solution (CQRS):
- **Command Service**: Only handles Updates/Inserts. Uses a relational DB (MySQL).
- **Query Service**: Only handles Selects. Uses a fast Read DB or a Search Engine (Elasticsearch).

When a Command happens, an event is sent to sync the Query DB. This allows you to scale the "Read" side infinitely!
