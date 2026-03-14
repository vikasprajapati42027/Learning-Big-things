# Test 30: SOLID - O (Open/Closed Principle)

## 🚪 1. What is OCP? (Simple Explanation)
OCP means **"Software entities should be OPEN for extension, but CLOSED for modification."**
Imagine your **Smartphone**. 
- You want a new calculator app? You **Extend** it by downloading an app. 
- You DON'T open the phone's circuit board and resolder the wires (**Modify**).

---

## 🖱️ 2. Coding Examples

### The Wrong Way:
If you have an `AreaCalculator` that uses `if (shape == "RECTANGLE")` and `else if (shape == "CIRCLE")`.
- Every time you add a new shape (like a Triangle), you have to go back and **Modify** the old calculator file. This is dangerous!

### The Right Way:
- Create a `Shape` interface with a `calculateArea()` method.
- Every new shape (Triangle, Hexagon) just implements this.
- The `AreaCalculator` never changes. It just calls `.calculateArea()` on whatever you give it.

---

## 🚀 3. Why use this?
1. **Stability**: You don't risk breaking old, working code when adding new features.
2. **Infinite Growth**: You can add 1,000 new shapes without touching the core math engine.
