# Test 26: DTO (Data Transfer Object) Pattern

## 📦 1. What is DTO? (Simple Explanation)
Imagine you are **Moving House**.
- You have 1,000 small items (spoons, pens, socks).
- Instead of carrying them one-by-one to the new house (1,000 trips!), you put them in a **Box** (The DTO).
- You carry 1 box. Much faster!
In networking, if you want a user's name, email, and age from a server, it's better to get them all in ONE "Object" instead of calling the server 3 times.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The DTO (`UserDTO.java`)
- This is just a "Box." It has no logic/methods except getters/setters.
- It only contains the data that the client needs.

### Step 2: The Logic (`UserBusinessObject.java`)
- This class talks to the Database. 
- It creates the DTOs and sends them to the UI.

---

## 🚀 3. Why use this?
1. **Performance**: Reduces the number of network calls (Round trips).
2. **Security**: You can hide sensitive data (like `password_hash`) by leaving it out of the DTO. Only put what the UI needs to see.

## ⚠️ 4. Senior Tip: Records in Java
In Java 14+, we use **`record`** for DTOs. It's much cleaner!
`public record UserDTO(String name, String email) {}`
