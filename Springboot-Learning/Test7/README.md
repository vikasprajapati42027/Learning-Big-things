# Test 7: REST Inputs (@PathVariable, @RequestParam, @RequestBody)

This lesson explains how your API can accept data from users.

## 1. Input Types Explained

| Input Type | Annotation | Example URL | Purpose |
| :--- | :--- | :--- | :--- |
| **Path Variable** | `@PathVariable` | `/user/123` | To identify a specific resource (ID). |
| **Request Param** | `@RequestParam` | `/search?q=java` | For filtering, sorting, or searching data. |
| **Request Body** | `@RequestBody` | *(In POST Body)* | For complex data or multiple fields (e.g., creating a user). |

---

## 2. Check Your Understanding (Quiz)

Read the following scenarios and answer them to yourself. (I will ask you in the chat too!)

**Question 1:** You want to find a book by its **unique ID** (like `/book/45`). Which annotation should you use?
1. `@RequestParam`
2. `@PathVariable`
3. `@RequestBody`

**Question 2:** You want to **filter** a list of products by a maximum price (like `/products?maxPrice=500`). Which annotation is best?
1. `@RequestParam`
2. `@PathVariable`
3. `@RequestBody`

**Question 3:** Why does `ProductRequest` need a **default constructor** (one with no arguments)?
- *Hint: Look at how Jackson works in the code comments.*

---

## How to test:
- **GET** requests can be tested in the browser.
- **POST** requests (like the `@RequestBody` one) usually require a tool like Postman or `curl`.
