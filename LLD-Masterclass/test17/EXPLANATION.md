# Test 17: Chain of Responsibility Design Pattern (Behavioral)

## ⛓️ 1. What is the Chain of Responsibility? (Simple Explanation)
Imagine you call **Customer Support**.
1. Level 1: A "Bot" answers. If it can't help, it passes you to...
2. Level 2: A "Customer Agent." If they can't help, they pass you to...
3. Level 3: A "Manager."
The Chain of Responsibility passes a request along a **Chain of Handlers**. Every handler decides either to process the request or pass it to the next person in line.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Abstract Handler (`AbstractLogger.java`)
- It contains a reference to the **`nextLogger`** (The next link in the chain).
- The `logMessage` method checks if the current level is correct, then passes the message to the next one automatically.

### Step 2: Concrete Handlers (`ConsoleLogger`, `ErrorLogger`, `FileLogger`)
- Each logger "Writes" at a different level (INFO, DEBUG, ERROR).
- **ErrorLogger** only cares about `ERROR`.
- **ConsoleLogger** handles everything starting from `INFO`.

### Step 3: Building the Chain (`ChainDemo.java`)
- We link them: `Error -> File -> Console`.
- When we send an "ERROR" message, it starts at the top and everyone in the chain gets a chance to log it.

---

## 🚀 3. Why use this?
1. **Reduces Coupling**: The sender of the request doesn't need to know which handler will eventually fix the problem.
2. **Flexibility**: You can add or remove links in the chain at any time without moving existing code.

## ⚠️ 4. Senior Tip: Middleware
In web frameworks like **Spring Security** or **Node.js Express**, "Middleware" is exactly this pattern. Each filter checks the request (Is it a user? Is it an admin?) and either blocks it or calls `next()`.
