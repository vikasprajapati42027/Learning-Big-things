# Test 21: Memento Design Pattern (Behavioral)

## 🕒 1. What is the Memento Pattern? (Simple Explanation)
Imagine you are playing a **Video Game** and you reach a "Checkpoint."
- You save your game (The Memento).
- You fight a boss and lose all your health.
- You press **"Restore to Checkpoint"**.
The Memento pattern stores the internal state of an object so that you can restore it to a previous state later without breaking encapsulation (hiding the details).

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Memento (`Memento.java`)
- This is a simple object that "holds" the data of a specific time. 

### Step 2: The Originator (`Originator.java`)
- This is the main object (like your Player). It has a state.
- It can "Create" a memento of itself.
- It can "Restore" itself using a memento.

### Step 3: The Caretaker (`CareTaker.java`)
- This is like the **Save File Manager**. 
- It keeps a list of mementos but doesn't know what's inside them. It just keeps them safe.

### Step 4: The Result (`MementoDemo.java`)
- We set the state to #1, #2, #3, and #4.
- We save #2 and #3.
- Later, we "travel back in time" to State #2 just by asking the Caretaker for the first save!

---

## 🚀 3. Why use this?
1. **Undo Mechanism**: Best for "Undo" (Ctrl+Z) in text editors or games.
2. **Encapsulation**: The Caretaker manages the saves without knowing how the Player object is built.

## ⚠️ 4. Senior Tip: Memory Consumption
Mementos can take a lot of RAM if your objects are huge. In production, we usually only save the **"Diff"** (what changed) instead of the whole object!
