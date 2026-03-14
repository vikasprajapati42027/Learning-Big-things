# Test 9: Prototype Design Pattern (Creational)

## 🐑 1. What is the Prototype Pattern? (Simple Explanation)
Imagine you are building a **Game** with thousands of **Soldiers**. 
- Creating a soldier from scratch takes 5 seconds (loading high-res 3D models, textures, weapons).
- Instead of calling `new Soldier()` 1,000 times (which takes 5000 seconds), you create ONE "Prototype" soldier and then **Clone** him!
The Prototype Pattern allows you to create new objects by copying an existing one, making it much faster.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Blueprint (`Shape.java`)
- We implement the **`Cloneable`** interface. This is a special Java rule that tells the system "This object can be copied."
- We override the `clone()` method to provide the copy logic.

### Step 2: Complex Objects (`Circle.java`, `Rectangle.java`)
- These represent the objects that might be "expensive" to create (e.g., they fetch data from a database).

### Step 3: The Cache (`ShapeCache.java`)
- This is where the magic happens. We maintain a `Map` (Hashtable) of original objects.
- When the app asks for a shape, we don't say `new Circle()`. We find the original and say **`.clone()`**.

### Step 4: The Result (`PrototypePatternDemo.java`)
- You load the cache once.
- Every time you need a shape, you get a fresh **copy** of the original. You can change the copy without affecting the original!

---

## 🚀 3. Why use this?
1. **Performance**: Much faster than using `new` for complex initialization.
2. **Reduced Subclassing**: You don't need a factory for every type of object.
3. **Deep Copy vs Shallow Copy**: Be careful! A "Shallow Copy" only copies values; a "Deep Copy" copies nested objects too.

## ⚠️ 4. Senior Tip: Object Pooling
The Prototype pattern is the foundation for "Object Pooling" used in Database Connections and Thread Pools to save system resources.
