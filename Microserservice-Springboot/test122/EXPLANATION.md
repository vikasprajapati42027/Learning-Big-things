# Test 122: Entity to DTO Mapping

Controlling exactly what data you expose in your API.

## Key Files:
- `UserDTOService.java`: Shows the critical difference between `UserEntity` (internal DB model) and `UserDTO` (safe API response).
- `EXPLANATION.md`: Why leaking DB entities is dangerous.

## Concept:
Your Entity has a `passwordHash`. If you return the Entity directly in your API, you accidentally expose the hash! A DTO is a carefully crafted response object that has only the fields safe for public exposure.
