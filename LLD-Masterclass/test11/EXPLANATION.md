# Test 11: Proxy Design Pattern (Structural)

## 🕵️ 1. What is the Proxy Pattern? (Simple Explanation)
Imagine you are at an **Office**. To visit a website, you use the office Wi-Fi. But the company has a **Firewall**.
- If you visit `google.com`, the firewall lets you through.
- If you visit `facebook.com`, the firewall stops you and says "Access Denied."
The Firewall is the **Proxy**. It stands in front of the "Real Internet" and controls access.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Common Interface (`Internet.java`)
- Defines the method `connectTo()`. Both the real object and the proxy must use this.

### Step 2: The Real Object (`RealInternet.java`)
- This is the actual service that does the work (connecting to the web). It doesn't know anything about blocking sites.

### Step 3: The Proxy (`ProxyInternet.java`)
- This is the **Security Guard**. 
- It has a list of `bannedSites`.
- When you ask to connect, it checks the list FIRST. If the site is bad, it throws an error. If it's safe, it calls the `RealInternet`'s connect method.

### Step 4: The Client (`ProxyDemo.java`)
- The app always talks to the **Proxy**. It thinks it's talking to the internet.
- The proxy adds the safety layer without the client knowing.

---

## 🚀 3. Types of Proxies
1. **Protection Proxy**: Controls access (our example).
2. **Virtual Proxy**: Hides an expensive object. It only creates the real object when someone actually needs it (Lazy Loading).
3. **Remote Proxy**: Represents an object that lives on a different server (used in Microservices/RMI).

## ⚠️ 4. Senior Tip: Proxy vs Decorator
- **Proxy**: Controls **Access** to an object. (Security/Lazy loading).
- **Decorator**: Adds **Extra Features** to an object. (Milk to Coffee).
