# Test 10: Facade Design Pattern (Structural)

## 📺 1. What is the Facade Pattern? (Simple Explanation)
Imagine you have a **Home Theater**. To watch a movie, you have to:
1. Turn on the Lights.
2. Dim the Lights.
3. Turn on the Projector.
4. Set Projector input to Netflix.
5. Turn on the Sound System.
6. Set Volume to 10.
That's 6 steps! The Facade Pattern is like a **Universal Remote**. You press **ONE** button labelled "Watch Movie," and it handles all 6 steps for you.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: Complex Subsystems (`SoundSystem.java`, `Projector.java`, etc.)
- These are the individual parts of the system. They have many small methods that can be confusing to use all together.

### Step 2: The Facade (`HomeTheaterFacade.java`)
- This is the **wrapper**. It knows about all the subsystems.
- It provides a very simple method: **`watchMovie()`**.
- Inside that method, it calls the `on()`, `dim()`, and `setVolume()` methods in the correct order.

### Step 3: The Client (`FacadeDemo.java`)
- The person using the theater (the client) only talks to the **Remote Control** (Facade).
- They don't need to know how the projector works or which port Netflix is on.

---

## 🚀 3. Why use this?
1. **Simplicity**: Hides complexity from the end user.
2. **Decoupling**: If you buy a NEW Sound System, you only change the Facade. Your client code (the Remote button) stays exactly the same!
3. **Layering**: You can create multiple facades for different layers of your app (e.g., a Mobile Facade vs a Web Facade).

## ⚠️ 4. Senior Tip: Facade vs Proxy
A **Facade** provides a *New/Simplified* interface. A **Proxy** provides the *Same* interface but adds control (like security or logging).
