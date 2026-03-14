# Test 38: Coupling vs Cohesion

## 🤝 1. Simple Explanation
- **Cohesion**: How well a molecule stays together. (Does this class focus on ONE thing?)
- **Coupling**: How much two molecules are stuck to each other. (If I change Class A, does Class B break?)

Imagine a **Football Team**.
- **High Cohesion**: Every player knows their job (Striker, Goalie). They are focused.
- **Low Coupling**: If the Goalie is injured, the Striker doesn't lose his ability to run. They coordinate, but they aren't "glued" together.

---

## 🖱️ 2. Goal: High Cohesion + Low Coupling

### High Cohesion (Good):
A class named `EmailValidator` only validates emails. It doesn't print PDFs or save to DB.

### Low Coupling (Good):
Use **Interfaces**. Instead of a `Shop` class needing a `BlueCreditCard`, it should just need a `PaymentMethod`. Now you can swap to `UPI` without touching the `Shop` code.

## 🚀 3. Why it matters:
- **High Cohesion** makes code easy to understand.
- **Low Coupling** makes code easy to change.
