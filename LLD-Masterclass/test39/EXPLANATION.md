# Test 39: Dependency Injection (DI)

## 💉 1. What is DI? (Simple Explanation)
Imagine you are a **Surgeon**.
- You need a **Scalpel** to perform surgery.
- **Bad way**: You build the scalpel yourself inside the operating room.
- **DI way**: An **Assistant** (The Injector) hands you the scalpel. 
You don't care where the scalpel came from; you just care that it follows the "Scalpel" rule.

---

## 🖱️ 2. Coding Application
Instead of a class creating its own dependencies (`new MyService()`), the dependencies are **passed in** (Injected) from the outside.

### Types of Injection:
1. **Constructor Injection**: Passing dependencies via the constructor. (Safest & Best).
2. **Setter Injection**: Passing via a setter method.
3. **Field Injection**: Using `@Autowired` on the field (Spring only - avoid if possible).

## 🚀 3. Why use this?
1. **Unit Testing**: You can pass a "Mock" service (Fake) to test your class easily.
2. **Decoupling**: Your class doesn't need to know how to create complex objects.
