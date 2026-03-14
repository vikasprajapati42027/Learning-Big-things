# Test 24: Null Object Pattern (Behavioral)

## 🕳️ 1. What is the Null Object Pattern? (Simple Explanation)
Every programmer hates the **`NullPointerException`**.
Usually, when a user is not found, we return `null`. Then we have to write `if (user != null)` every time.
The Null Object pattern returns a **"Doing Nothing" object** instead of `null`. This object has the same methods but they just print "Nothing to show."

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Base Class (`AbstractCustomer.java`)
- Define the common logic.

### Step 2: The Real One (`RealCustomer.java`)
- Standard customer that has a real name.

### Step 3: The Null One (`NullCustomer.java`)
- This class is the **Safety Net**. 
- It has a `name` like "Not available" and its `isNil()` is true.

### Step 4: Use it (`NullObjectDemo.java`)
- When we look for "Julie" (who doesn't exist), we get a `NullCustomer`.
- We can call `.getName()` safely without checking if `c2` is null!

---

## 🚀 3. Why use this?
1. **Cleaner Code**: Removes thousands of `if (obj != null)` checks.
2. **Reliability**: Prevents the app from crashing due to unexpected nulls.

## ⚠️ 4. Senior Tip: Java Optional
In modern Java (8+), we use **`Optional<T>`** which is a more advanced version of this pattern built directly into the language!
