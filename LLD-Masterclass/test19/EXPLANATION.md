# Test 19: State Design Pattern (Behavioral)

## 🚦 1. What is the State Pattern? (Simple Explanation)
Imagine a **Vending Machine**.
- If it has money -> It behaves differently (Lets you pick a soda).
- If it has OUT OF STOCK -> It behaves differently (Returns your money).
Instead of writing 100 `if (state == "READY")` blocks, the object **swaps its entire behavior class** when its internal state changes.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The State Interface (`State.java`)
- Defines what actions can be taken (e.g., `doAction()`).

### Step 2: The Context (`Context.java`)
- This is the machine itself. 
- It holds a reference to the **Current State**.
- When you interact with the context, it simply tells the *current state* to handle it.

### Step 3: Concrete States (`StartState.java`, `StopState.java`)
- These are the different "Personalities" of the object.
- When the `StartState` finishes, it can automatically tell the context: "Hey, I'm done, now set yourself to StopState."

### Step 4: The Result (`StateDemo.java`)
- The context stays the same, but its "behavior" changes completely as we switch states.

---

## 🚀 3. Why use this?
1. **Removes If-Else**: It cleans up complex logic where an object has 10+ modes.
2. **SRP (Single Responsibility)**: The logic for "Start" is strictly inside the `StartState` class.

## ⚠️ 4. Senior Tip: State vs Strategy
- **Strategy**: You choose the logic (e.g., "I want to pay by UPI").
- **State**: The logic is chosen based on the internal situation (e.g., "The battery is low, so I am now in Power Saving Mode").
