# Test 8: Abstract Factory Design Pattern (Creational)

## 🏢 1. What is the Abstract Factory? (Simple Explanation)
Imagine you are buying **Furniture**.
- You want a **Victorian Style** chair and table.
- Or you want a **Modern Style** chair and table.
The Abstract Factory is like a **Furniture Shop** that guarantees all items you buy will **Match**. 
If you pick the "Victorian Shop," you get a Victorian Chair AND a Victorian Table. You won't accidentally get a Modern Chair.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: Multiple Product Interfaces (`Button.java`, `Checkbox.java`)
- We have different types of products. All buttons must have a `paint()` method.

### Step 2: Concrete Products (`WindowsButton.java`, `MacButton.java`, etc.)
- These are the actual implementations for each operating system.

### Step 3: The "Master" Factory Interface (`GUIFactory.java`)
- This is the **Abstract Factory**. 
- It defines methods to create a "Family" of products (Button and Checkbox).

### Step 4: System-Specific Factories (`WindowsFactory.java`, `MacFactory.java`)
- The Windows Factory ONLY creates Windows buttons and checkboxes.
- The Mac Factory ONLY creates Mac buttons and checkboxes.
- They ensure you don't mix a Windows button with a Mac checkbox!

### Step 5: The Client (`AbstractFactoryDemo.java`)
- Your application just asks for a "Factory." It doesn't care which one.
- It calls `createButton()` and gets a button that "matches" the system style automatically.

---

## 🚀 3. Abstract Factory vs Factory Method
- **Factory Method**: Focuses on **ONE** product (e.g., just a Ticket).
- **Abstract Factory**: Focuses on a **FAMILY** of related products (e.g., Chair + Sofa + Coffee Table).

## ⚠️ 4. Senior Tip: Complexity
This pattern is very powerful but adds many classes. Use it ONLY when you have products that must work together in sets (Themes, OS styles, DB Drivers).
