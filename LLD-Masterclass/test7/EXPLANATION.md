# Test 7: Builder Design Pattern (Creational)

## 🏗️ 1. What is the Builder Pattern? (Simple Explanation)
Imagine you are filling out a **Registration Form**.
- Some fields are **Mandatory** (*First Name, Email*).
- Some fields are **Optional** (*Age, Phone, Address*).
If you used a normal constructor, it would look like this: `new User("Vikas", "P", 25, "987...", "Mumbai", true, ... 20 more fields)`. This is hard to read and easy to make mistakes.
The Builder Pattern lets you build the object **step-by-step** using only the fields you need.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Main Class (`User.java`)
- We make the fields **private** and **final**.
- We make the constructor **private**. This means the ONLY way to create a User is through the Builder.

### Step 2: The Inner Builder Class
- We create a static class inside User called `UserBuilder`.
- It has the SAME fields as the User class.

### Step 3: Required Fields
- We put the required fields (First Name, Last Name) in the **Builder's Constructor**. You can't start building without them!

### Step 4: Fluid Methods (Method Chaining)
- Each method (like `age()`) sets the value and then returns **`this`** (the builder itself).
- This allows you to chain them: `.age(25).phone("...")`.

### Step 5: The `build()` Method
- This is the "Finish" button. It calls the private User constructor and gives you the final object.

---

## 🚀 3. Why use this?
1. **Readable Code**: It looks like English.
2. **Immutability**: Once the User is built, it cannot be changed (Safety).
3. **Avoid Parameter Confusion**: You never have to guess if the 3rd parameter is "Phone" or "Email".

## ⚠️ 4. Senior Tip: Lombok
In real Spring Boot jobs, we often use a library called **Lombok**. You just type `@Builder` on top of your class, and Java writes all this code for you!
