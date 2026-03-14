# Test 14: Flyweight Design Pattern (Structural)

## 🪶 1. What is the Flyweight Pattern? (Simple Explanation)
Imagine you are building a **Forest Game** with **1 million trees**.
- Each tree has a "Type" (Oak, Pine), a "Color" (Green), and a high-res "3D Texture" (10MB).
- If you create 1,000,000 separate objects, you need **10,000 GB of RAM**. Your game will crash!
The Flyweight pattern **Shares** the heavy data (Texture, Color) and only stores the unique data (X, Y coordinates) for each tree. This reduces RAM usage from GBs to MBs.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Shared Object (`TreeType.java`)
- This stores the data that is the SAME for many objects (The "Flyweight").
- It contains the `name` and `color`. 

### Step 2: The Factory (`TreeFactory.java`)
- This is the **Brain**. It keeps a list (Map) of existing types.
- If you ask for a "Green Oak" and it already exists, it gives you the **old one** instead of creating a new one.

### Step 3: The Light Object (`Tree.java`)
- This stores only the data that is UNIQUE for every single tree (The X and Y coordinates).
- It simply "Points" to the shared `TreeType`.

### Step 4: The Result (`FlyweightDemo.java`)
- We "plant" 10,000 trees.
- Even though we have 10,000 `Tree` objects, we only have **2** `TreeType` objects in memory!

---

## 🚀 3. Intrinsic vs Extrinsic State
- **Intrinsic (Internal)**: Data that belongs together and is shared (e.g., Font name, Tree color).
- **Extrinsic (External)**: Data that varies based on context (e.g., Cursor position, Tree coordinates).

## ⚠️ 4. Senior Tip: String Pool
Java uses the Flyweight pattern for **String Interning**. When you say `String s1 = "Hello"`, Java checks a "pool." If "Hello" exists, it gives you the same memory reference. This is why Strings are immutable!
