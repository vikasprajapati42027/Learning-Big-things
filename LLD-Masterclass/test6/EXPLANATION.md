# Test 6: Decorator Design Pattern (Structural)

## ☕ 1. What is the Decorator Pattern? (Simple Explanation)
Imagine you have a **Plain Coffee**. Instead of creating 100 different classes like `CoffeeWithMilk`, `CoffeeWithSugar`, `CoffeeWithMilkAndSugar`, etc., you use **Sticky Notes** (Decorators). 
Each sticky note adds a feature (Milk, Sugar) to the existing coffee. You can stack as many as you want!

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Basic Product (`Coffee.java`)
- This is the interface that defines what every coffee must do: give a name and a price.

### Step 2: The Plain Object (`SimpleCoffee.java`)
- This is your basic coffee (costing ₹50). It doesn't have anything extra.

### Step 3: The Decorator Base (`CoffeeDecorator.java`)
- This is the **wrapper**. It "contains" a coffee object inside it. 
- It implements the same `Coffee` interface so it looks like a coffee to the outside world.

### Step 4: The Add-ons (`MilkDecorator.java`, `SugarDecorator.java`)
- These classes extend the base decorator.
- They take the existing coffee, add their own text to the description, and add their own price to the cost.

### Step 5: How it works (`DecoratorDemo.java`)
- You start with a `SimpleCoffee`.
- You "wrap" it in a `MilkDecorator`.
- You "wrap" that whole thing in a `SugarDecorator`.
- It's like an Onion with layers!

---

## 🚀 3. Why use this?
1. **Avoid Class Explosion**: You don't need million classes for every combination of toppings.
2. **Dynamic**: You can add or remove toppings at **Runtime** (while the app is running).

## ⚠️ 4. Senior Tip: Decorator vs Inheritance
- **Inheritance**: You decide the behavior when you **write** the code (Static).
- **Decorator**: You decide the behavior when you **run** the code (Dynamic).
