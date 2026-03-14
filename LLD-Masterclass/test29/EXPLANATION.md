# Test 29: SOLID - S (Single Responsibility Principle)

## 🎯 1. What is SRP? (Simple Explanation)
SRP means **"A class should have only ONE reason to change."**
Imagine a **Swiss Army Knife**. It has a knife, a screwdriver, and a saw. If you want to make the screwdriver longer, you might accidentally break the knife.
In coding, one class should do **ONE JOB**.

---

## 🖱️ 2. Coding Examples

### The Wrong Way:
A `UserService` that saves to the DB AND sends an email AND prints a PDF. 
- If the Database changes, you edit this file.
- If the Email provider changes, you edit the SAME file.
This creates "Spaghetti Code."

### The Right Way:
- `UserRepository`: Only handles database logic.
- `EmailService`: Only handles emails.
Now, if you want to change the email logic, you ONLY touch the `EmailService` file. No risk of breaking the database code!

---

## 🚀 3. Why use this?
1. **Easy to Test**: You can test the Email logic without a Database.
2. **Better Organization**: Every file name tells you exactly what it does.
