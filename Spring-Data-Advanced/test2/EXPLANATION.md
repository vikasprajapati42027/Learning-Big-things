# Test 2: Single Table Inheritance

## 📄 1. Concept
All classes in the hierarchy are stored in ONE table. A "Discriminator Column" (like `payment_type`) tells Hibernate which subclass to create.

## 🚀 2. Why use it?
- **Speed**: No joins needed.
- **Simplicity**: One table to manage.
