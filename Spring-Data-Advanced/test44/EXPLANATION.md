# Test 44: Dynamic Update & Insert

## ⚡ 1. Concept
Normally, Hibernate sends ALL columns in an update. `@DynamicUpdate` calculates the "diff" and only sends what changed.
