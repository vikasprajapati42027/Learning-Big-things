# Test 40: Aspect-Oriented Programming (AOP)

## 🕵️ 1. What is AOP? (Simple Explanation)
Imagine you are building a **Bank App**. You have 100 methods (Transfer, Withdraw, Balance Check). 
- Every single method must **Log** the time it started.
- Every single method must **Check Security**.
If you write "Security Check" 100 times, you are violating the **DRY** principle.
AOP is like a **Magic Guard** who stands over your code and says: "Whenever any method runs, I will automatically perform the security check for you."

---

## 🖱️ 2. Key Terms
1. **Aspect**: The common logic (e.g., Logging).
2. **Pointcut**: Where to apply the logic (e.g., "All methods in `Service` package").
3. **Advice**: When to apply it (e.g., "Before", "After", "Around").

## 🚀 3. Use Cases:
- **Logging**: Log every database call automatically.
- **Transactions**: Start a transaction before a method and commit it after.
- **Security**: Check user permissions before allowing a method to run.

## ⚠️ 4. Senior Tip: Spring AOP
In Spring Boot, we use `@Aspect` and `@Before` annotations. It makes your business logic very clean because it's not cluttered with logging and security code.
