# Test 22: Visitor Design Pattern (Behavioral)

## �� 1. What is the Visitor Pattern? (Simple Explanation)
Imagine you have a **House**.
- You have furniture like a **TV**, **Sofa**, and **Fridge**.
- A **Repairman** (The Visitor) comes to your house. 
- He "Visits" the TV to fix it. He "Visits" the Fridge to clean it.
You didn't need to teach the Fridge how to fix itself. The logic stays with the Repairman.
The Visitor pattern lets you add new operations to existing objects without changing them.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Element (`ComputerPart.java`)
- Every part (Keyboard, Monitor) has an `accept()` method. This is like "Opening the door" for the visitor.

### Step 2: The Visitor Interface (`ComputerPartVisitor.java`)
- Define "Visit" methods for every type of part.

### Step 3: Concrete Visitor (`ComputerPartDisplayVisitor.java`)
- This class contains the actual logic (Printing). 
- If you wanted to "Export to JSON," you would just make a NEW Visitor class without touching Keyboard or Monitor!

### Step 4: The Result (`VisitorDemo.java`)
- The elements (Monitor/Keyboard) "Accept" the visitor, and the visitor performs the action.

---

## 🚀 3. Why use this?
1. **Open-Closed Principle**: You can add new behaviors (Visitors) to classes without modifying them.
2. **SRP (Single Responsibility)**: The data stays in the Element, and the logic stays in the Visitor.

## ⚠️ 4. Senior Tip: The "Acyclic Visitor"
Visitor pattern is hard to change if you add a NEW element (like a Mouse) because you have to update every Visitor interface. Use it only when the Elements are stable!
