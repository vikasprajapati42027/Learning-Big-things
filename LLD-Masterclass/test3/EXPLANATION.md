# Test 3: Factory Design Pattern (Creational)

## 🏗️ 1. What is the Factory Pattern? (Simple Explanation)
Imagine you go to a **Pizza Shop**. You don't go into the kitchen and tell the chef "Use 100g dough, 50g cheese, bake for 10 mins." You simply say: **"Give me a Pepperoni Pizza."**
The Factory Pattern is that kitchen. You tell it **WHAT** you want, and it handles the complicated creation logic for you.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: Create the Interface (`Notification.java`)
- This is the "Blueprint." Every notification (Email, SMS) must follow this rule.
- *Action*: Define a method `notifyUser()`.

### Step 2: Implement the Services (`EmailNotification.java`, etc.)
- These are the "Concrete" classes.
- **Email**: Implementation for sending emails.
- **SMS**: Implementation for sending SMS.

### Step 3: Create the "Factory" (`NotificationFactory.java`)
- This is the **most important part**.
- Instead of using `new EmailNotification()` everywhere in your app, you ask this class.
- *Logic*: It uses a `switch` statement to decide which object to build.

### Step 4: Use the Factory (`FactoryPatternDemo.java`)
- In your main app, you simply pass a String (like "EMAIL").
- The app doesn't know *how* the email is built; it just knows it got a `Notification` object to use.

---

## 🚀 3. Why use this in Interviews?
1. **Abstraction**: The client code is decoupled from the specific classes.
2. **Maintenance**: If you add a new "WhatsApp" notification, you only change the Factory, not the whole app.
3. **Open-Closed Principle**: You can add new products without breaking existing code.

## ⚠️ 4. Senior Tip: Don't Overuse It!
If you only have 2 simple classes that never change, don't build a Factory. Only use it when the creation logic is complex or the types might grow (like adding 10 different payment gateways).
