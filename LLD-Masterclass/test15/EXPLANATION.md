# Test 15: Command Design Pattern (Behavioral)

## 🔘 1. What is the Command Pattern? (Simple Explanation)
Imagine you are at a **Restaurant**.
- You tell the **Waiter**, "I want a Pizza."
- The Waiter writes it on a **Piece of Paper** (The Command).
- The Waiter gives that paper to the **Chef** (The Receiver).
The Waiter doesn't need to know *how* to cook the pizza. He just passes the "Command object" (the paper) which contains all the instructions.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Command Interface (`Command.java`)
- Defines a simple `execute()` method.

### Step 2: The Receiver (`Light.java`)
- This is the object that actually does the work (turning a light on or off).

### Step 3: Concrete Commands (`LightOnCommand.java`)
- This class "Wraps" the receiver. 
- When `execute()` is called, it calls `light.on()`.

### Step 4: The Invoker (`RemoteControl.java`)
- This is the remote or the waiter. 
- It has a slot for a Command. It doesn't know it's a "Light" command; it just knows it can call `.execute()`.

### Step 5: The Result (`CommandDemo.java`)
- You can change what the remote button does at runtime by passing different command objects!

---

## 🚀 3. Why use this?
1. **Undo/Redo**: You can store a list of commands and call `undo()` on them to reverse actions.
2. **Queuing**: You can put commands in a queue (like a print queue) and run them later.
3. **Decoupling**: The remote button and the light bulb don't need to know each other directly.

## ⚠️ 4. Senior Tip: Undo Feature
In an interview, always mention that Command Pattern is the best way to implement **Undo/Redo** functionality in apps like Photoshop or Word.
