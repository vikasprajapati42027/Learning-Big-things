# Test 31: SOLID - L (Liskov Substitution Principle)

## 🔄 1. What is LSP? (Simple Explanation)
LSP means **"Subclasses should be able to replace their Parent classes without breaking the app."**
Imagine a **Remote Control Toy Car**. If you replace the batteries with a different brand, the car should still run. If the new batteries make the car catch fire, that's an LSP violation!

---

## 🖱️ 2. The "Square vs Rectangle" Problem
This is the most famous example.
- A Square **is a** Rectangle, right?
- But a Rectangle has `setWidth()` and `setHeight()`.
- If you call `setWidth(10)` on a Square, it must also change height to 10 to stay a square.
- This "Surprises" the code which was expecting a normal rectangle. **Violation!**

### The Solution:
Only inherit if the child can do **Everything** the parent does without surprises.
- A **Sparrow** can fly.
- An **Ostrich** cannot.
Instead of `Bird.fly()`, create a `FlyingBird` sub-category.

---

## 🚀 3. Why use this?
1. **No Surprises**: You can swap objects safely.
2. **Correct Hierarchy**: Forces you to think: "Is this REALLY a child of that category?"
