# Test 33: SOLID - D (Dependency Inversion Principle)

## 🔌 1. What is DIP? (Simple Explanation)
DIP means **"Depend on Abstractions, not Concretions."**
Imagine your **Wall Power Socket**. 
- The socket is the **Interface**.
- It doesn't care if you plug in a Fan, a Laptop, or a TV. 
- The "Plug" must just follow the "Socket's" shape.
If your Fan was "Hard-wired" into the wall, you couldn't use the wall for anything else!

---

## 🖱️ 2. Coding Examples

### The Wrong Way:
Inside a `Computer` class, you write: `private StandardKeyboard k = new StandardKeyboard();`.
- Now your computer is "Married" to the `StandardKeyboard`. 
- If the user wants a `MacKeyboard`, you have to delete code and rewrite the `Computer` class.

### The Right Way:
- Create a `Keyboard` interface.
- Let the `Computer` take a `Keyboard` in its constructor.
- Now, the user can pass ANY keyboard without changing the Computer's code!

---

## 🚀 3. Why use this?
1. **Decoupling**: High-level modules (Computer) don't care about low-level details (Brand of Keyboard).
2. **Testability**: You can pass a "Fake Keyboard" (Mock) during testing.

## ⚠️ 4. Senior Tip: Spring Framework
DIP is the core engine of **Spring Boot**. When you use `@Autowired`, Spring "Inverts the Control" and gives you the dependency from its container!
