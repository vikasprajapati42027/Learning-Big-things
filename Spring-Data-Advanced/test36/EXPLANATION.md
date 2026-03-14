# Test 36: Soft Deletes

## 🧊 1. Concept
Uses `@SQLDelete` to change `DELETE` into `UPDATE ... SET deleted = true`. Keeps data for legal/recovery reasons.
