# Test 20: Mediator Design Pattern (Behavioral)

## ✈️ 1. What is the Mediator Pattern? (Simple Explanation)
Imagine an **Airport**.
- If every pilot talked to every other pilot directly to avoid crashes, the radio would be a mess! "Hey Pilot 1, I am landing on Runway 4, stay away!"
- Instead, everyone talks to the **Air Traffic Control (ATC) Tower**.
The ATC Tower is the **Mediator**. It handles communication between all pilots so the pilots don't need to know about each other.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Mediator (`ChatRoom.java`)
- This class centralizes all the interaction.
- It has a static or instance method `showMessage()` that decides how the messages are displayed.

### Step 2: The Colleagues (`User.java`)
- These are the people (or objects) that want to talk.
- Instead of having a `List<User>` inside every User (messy!), they only have a reference to the `ChatRoom`.
- When they want to say something, they just tell the ChatRoom.

### Step 3: The Result (`MediatorDemo.java`)
- Users send messages without needing to know who else is in the chat room. 
- The ChatRoom handles the "many-to-many" complexity.

---

## 🚀 3. Why use this?
1. **Reduces Coupling**: Objects don't need to hold references to 50 other objects.
2. **Centralized Logic**: Communication rules are in one place (the Mediator).

## ⚠️ 4. Senior Tip: Mediator vs Observer
- **Observer**: One object broadcasts news to many subscribers (One-to-Many).
- **Mediator**: Many objects talk to each other through a central point (Many-to-Many).
