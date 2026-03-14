# Test 125: JPA Auditing (Auto-Timestamps)

Letting Spring automatically fill `createdAt` and `updatedAt` columns.

## Key Files:
- `AuditableOrder.java`: An entity using `@CreatedDate` and `@LastModifiedDate`.
- `EXPLANATION.md`: How Spring's Auditing framework works.

## Concept:
Instead of manually setting `createdAt = LocalDateTime.now()` in every service method, Spring does it automatically using JPA Auditing. Add `@EntityListeners(AuditingEntityListener.class)` and Spring fills the fields — perfect, consistent, and zero manual effort.
