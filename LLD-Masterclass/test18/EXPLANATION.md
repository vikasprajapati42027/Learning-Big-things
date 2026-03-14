# Test 18: Template Method Pattern (Behavioral)

## 📝 1. What is the Template Method? (Simple Explanation)
Imagine you are making **Maggi (Instant Noodles)**. The "Standard Steps" are:
1. Boil Water.
2. Add Noodles.
3. Add Masala.
4. Serve.
The steps are always the same! You can't add Masala before Boiling Water.
The Template Method pattern defines the **Skeleton** (the sequence) of an algorithm in a base class, but lets subclasses change specific steps without changing the structure.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Master Template (`Game.java`)
- It has a method called `play()` marked as **`final`**.
- *Why final?* Because we don't want anyone to change the order (Start -> Play -> End).
- It also has "Abstract" steps that each game must define for itself.

### Step 2: Specific Games (`Cricket`, `Football`)
- They inherit from `Game`.
- They provide their own text for `initialize()`, `startPlay()`, etc.
- But they **cannot** change the fact that `initialize()` happens before `startPlay()`.

### Step 3: The Result (`TemplateDemo.java`)
- When you call `game.play()`, the base class runs the steps in the correct order. The subclass just provides the details for each step.

---

## 🚀 3. Why use this?
1. **Code Reuse**: The common logic (`play()`) is written only once in the base class.
2. **Standardization**: It forces every subclass to follow the same lifecycle/workflow.

## ⚠️ 4. Senior Tip: Hook Methods
Sometimes, you add an empty method in the base class called `isExtraMasalaNeeded()`. This is called a **Hook**. Subclasses can "Override" it to change a small part of the behavior without changing the whole algorithm.
