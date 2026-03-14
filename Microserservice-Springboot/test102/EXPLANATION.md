# Test 102: API Versioning Strategies

Ensuring backward compatibility as your API evolves.

## Key Files:
- `VersionController.java`: Demonstrates URI versioning (`/v1/`) and Header versioning (`X-API-VERSION`).
- `EXPLANATION.md`: Why versioning is critical for stable microservices.

## Why use it?
When you change your API, you can't force all mobile apps to update instantly. Versioning allows you to support the "Old" data format while launching the "New" one, giving users time to migrate.
