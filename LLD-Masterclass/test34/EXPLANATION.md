# Test 34: DRY (Don't Repeat Yourself) Principle

## ❌ 1. What is DRY? (Simple Explanation)
DRY means **"Every piece of knowledge must have a single, unambiguous representation within a system."**
Imagine you have a **Recipe** for a cake. 
- If you copy the recipe onto 10 different pages in your notebook, and later you decide to add "Walnuts," you have to remember to change all 10 pages. 
- If you forget even one, your notebook becomes confusing and wrong.

---

## 🖱️ 2. Coding Application
If you have a logic (like "Calculating Tax" or "Email Validation") that appears in 5 different files, **Move it to a Utility class**.

### Benefits:
1. **Single Point of Change**: Change the tax rate once, it updates the whole app.
2. **Readability**: Smaller methods are easier to read.
3. **Consistency**: You don't have different modules calculating things in slightly different ways.

## ⚠️ 3. Senior Tip: Over-abstraction
Don't be a "DRY fanatic." Sometimes, two things look the same today but will grow differently tomorrow. Only DRY your code when the **Logic/Business Rule** is the same, not just because two lines look similar!
