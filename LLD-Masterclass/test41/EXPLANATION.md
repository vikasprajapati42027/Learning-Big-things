# Test 41: Rule Engine Pattern

## 🧠 1. Simple Explanation
Imagine an **E-Commerce app** with 50 different discount rules:
- "If Sunday, 10% off."
- "If first order, 20% off."
- "If total > 5000, free shipping."
If you use `if-else`, your code becomes a 1,000-line mess. A **Rule Engine** lets you treat each rule as a separate object. You throw an Order into the engine, and it applies all matching rules.

## 🚀 2. Why use this?
Better than a giant switch-case. You can add or remove rules dynamically without touching the core processing logic.
