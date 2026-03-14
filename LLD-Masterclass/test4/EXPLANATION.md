# Test 4: Singleton Design Pattern (Creational)

## 🛡️ 1. What is the Singleton Pattern? (Simple Explanation)
Imagine a **Kingdom** with only **One King**. If anyone wants to talk to the King, they go to the same person. There can never be two kings.
The Singleton Pattern ensures that a class has **only one instance** in the entire application (e.g., a Database Connection Pool or a Logger).

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: Hide the Door (`Private Constructor`)
- In `EagerSingleton.java`, we make the constructor `private`.
- *Why?* This stops other classes from saying `new Singleton()`.

### Step 2: The Eager Way
- We create the object as soon as the app starts. It's simple, but it wastes memory if nobody ever uses the class.

### Step 3: Double-Checked Locking (`ThreadSafeSingleton.java`)
- This is the **Senior Interview Question**.
- **First Check**: If instance exists, return it (Fast).
- **Synchronized block**: Only allow one thread at a time to create the object.
- **Second Check**: Re-check if another thread created it while we were waiting.
- **`volatile`**: Ensures that the object is fully created before other threads see it.

### Step 4: The Bill Pugh Method (`BillPughSingleton.java`)
- Uses a "Static Inner Class." The object is only created when `getInstance()` is called. It is thread-safe and very efficient!

### Step 5: The Best Way (`EnumSingleton.java`)
- Using an `Enum` is the most secure way. It handles thread-safety and prevents hackers from using "Reflection" to create multiple instances.

---

## 🚀 3. Top Interview Questions
- **Q**: Why is `volatile` used in Double-Checked Locking?
- **A**: To prevent "Instruction Reordering" where a thread might see a half-initialized object.
- **Q**: Can you break a Singleton?
- **A**: Yes, using Reflection, Serialization, or Cloning (unless you handle them).

## ⚠️ 4. Senior Tip: Avoid "Singleton Abuse"
Too many singletons make unit testing hard because they maintain "Global State." Use them sparingly for things like Logging, Caching, or Config loading.
