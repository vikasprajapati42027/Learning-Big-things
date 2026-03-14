# Test 25: Service Locator Pattern (J2EE)

## �� 1. What is Service Locator? (Simple Explanation)
Imagine you are at a **Hotel**.
- You want a "Taxi." You don't call the taxi company yourself.
- You call the **Receptionist** (The Service Locator).
- The receptionist finds a taxi for you. Next time you ask, the receptionist might already have a taxi waiting outside (**Caching**).
The Service Locator centralizes the lookup of services to improve performance.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Service Interface (`Service.java`)
- Every service (Email, SMS) must follow this.

### Step 2: The Cache (`Cache.java`)
- This stores services we already looked up. It's much faster to take something from memory than to find it again.

### Step 3: The Locator (`ServiceLocator.java`)
- This is the **Brain**. 
- It first checks the **Cache**.
- If not there, it "creates" (finds) the service and adds it to the cache for next time.

---

## 🚀 3. Why use this?
1. **Abstraction**: The client doesn't need to know how services are created.
2. **Performance**: Caching avoids expensive lookups.

## ⚠️ 4. Senior Tip: Dependency Injection (DI)
Service Locator was the standard way to do things in old Java (J2EE). Today, we use **Dependency Injection (Spring Boot)**. 
- In Service Locator: You **Ask** for a service.
- In DI: The service is **Given** to you automatically (via `@Autowired`).
