# Test 23: Interpreter Design Pattern (Behavioral)

## 🗣️ 1. What is the Interpreter Pattern? (Simple Explanation)
Imagine you are building a **Basic Calculator** or a **Search Engine**.
- If a user types "Java AND Senior," you need to understand (interpret) that they want someone who knows Java AND is senior.
The Interpreter pattern defines a grammar for a language and uses an interpreter to process sentences in that language.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Expression Interface (`Expression.java`)
- Every rule must have an `interpret()` method that returns true or false.

### Step 2: Terminal Expression (`TerminalExpression.java`)
- These are the basic words (e.g., "Robert", "John").

### Step 3: Logic Expressions (`OrExpression.java`)
- These combine terminal expressions using logic (OR, AND). 

### Step 4: The Result (`InterpreterDemo.java`)
- We create a rule: "If the input contains Robert OR John, it is a MALE."
- We test this rule with different strings.

---

## 🚀 3. Why use this?
1. **Domain Specific Languages (DSL)**: Great for building small languages (like SQL-lite or property filters).
2. **Simplified Grammar**: Easy to extend by adding new expression types.

## ⚠️ 4. Senior Tip: Complexity
Don't use this for complex languages like Java or Python. It gets way too messy. Use tools like **ANTLR** for big language parsing.
