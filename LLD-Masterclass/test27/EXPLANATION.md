# Test 27: DAO (Data Access Object) Pattern

## 🗄️ 1. What is DAO? (Simple Explanation)
Imagine you are building an app that uses a **MySQL Database**. 
- If you write SQL code directly inside your `Controller.java`, and then next month you switch to **MongoDB**, your app will break.
The DAO pattern **hides** the database details. Your app talks to an "Interface." It doesn't care if the data is coming from MySQL, an Excel file, or a Cloud API.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Model (`Student.java`)
- Just a simple object representing the data.

### Step 2: The Interface (`StudentDAO.java`)
- This is the **Contract**. It says "We can list, get, and update students." It DOES NOT say *how* (SQL vs NoSQL).

### Step 3: The Implementation (`StudentDAOImpl.java`)
- This is where the actual code (SQL queries or List manipulation) lives. If you change your DB, you only change this file!

---

## 🚀 3. Why use this?
1. **Clean Code**: Business logic (Service) is separated from Database logic (DAO).
2. **Easy Testing**: You can "Mock" the database during testing.

## ⚠️ 4. Senior Tip: Repository Pattern
In modern Spring Boot, we use the **Repository Pattern**. It's very similar to DAO, but it provides even more magic (like `findById` automatically).
