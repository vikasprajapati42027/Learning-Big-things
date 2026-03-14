# Test 37: Composition vs Inheritance

## 👪 1. Simple Explanation
- **Inheritance**: "X **IS A** Y" (A Dog is an Animal).
- **Composition**: "X **HAS A** Y" (A Car has an Engine).

Imagine you are building a **Robot**.
- **Inheritance Way**: You create a `WalkingRobot`. If you want it to swim, you have to create a `WalkingSwimmingRobot`. It gets very confusing very quickly (The "Diamond Problem").
- **Composition Way**: You give the robot "Legs" and "Fins" as plugins. If it needs to fly, you just plug in "Wings."

---

## 🖱️ 2. Why favor Composition?
1. **Flexibility**: You can change the "plugins" (parts) at runtime.
2. **Visibility**: Inheritance exposes the parent's internals to the child (Breaking encapsulation). Composition is private.
3. **Avoids "God Classes"**: You don't end up with one giant parent class that every child is stuck with.

## 🚀 3. Rule of Thumb:
Always try to use **Composition** first. Only use **Inheritance** when it is 100% certain that one thing is a sub-type of another (e.g., `SavingsAccount` is an `Account`).
