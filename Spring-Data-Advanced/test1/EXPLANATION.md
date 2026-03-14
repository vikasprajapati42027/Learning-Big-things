# Test 1: @MappedSuperclass

## 🏛️ 1. Concept
Use `@MappedSuperclass` when you have common fields (like `id`, `createdAt`) that multiple entities need, but the parent itself is NOT a table.

## 🖱️ 2. Hierarchy Details
- **Parent (`BaseEntity`)**: Shares code, no table.
- **Child (`UserEntity`)**: Has its own table, inherits fields.
