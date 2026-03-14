# Test 91: Hexagonal Architecture

Isolation of the Domain logic.

## Why use it?
What if you want to switch from MySQL to MongoDB?
- **Standard way**: You have to change your `@Entity` classes and service logic.
- **Hexagonal way**: You only change the **Adapter** (the outer shell). The **Core** logic remains untouched.

## Goal:
Your business logic should depend on **Interfaces (Ports)**, not on technical details (Databases, REST Controllers).
"The core doesn't care if data comes from a Website, a Mobile App, or a CLI script."
