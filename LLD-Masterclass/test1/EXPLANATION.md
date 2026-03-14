# Test 1: Strategy Design Pattern (Behavioral)

## 🎯 1. What is the Strategy Pattern? (Simple Explanation)
Imagine you are at the **Checkout** of a website. It asks: "How do you want to pay?"
- Option A: Credit Card
- Option B: UPI (Google Pay)
- Option C: Cash on Delivery
Instead of writing one giant `if-else` block inside the `checkout()` method, you create separate "Strategy" classes for each payment method. You can swap them at any time!

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Contract (`PaymentStrategy.java`)
- Every payment method must have a `pay()` method. This is the common interface.

### Step 2: Individual Strategies (`CreditCardPayment.java`, `UpiPayment.java`)
- These are the specific ways to pay.
- You can add a `BitcoinPayment` later without changing any existing code!

### Step 3: The Context (`ShoppingCart.java`)
- This is the class that uses the strategy. 
- It doesn't know *how* the payment happens; it just calls `.pay()`.
- It has a `setPaymentMethod()` method to swap strategies at runtime.

### Step 4: The Result (`StrategyDemo.java`)
- Notice how we create a single `cart` but change its behavior simply by passing a different object.

---

## 🚀 3. Why use this?
1. **Open-Closed Principle**: Add new features (Bitcoin) without modifying old code.
2. **Easy Testing**: You can test the UPI logic separately from the Shopping Cart logic.

## ⚠️ 4. Senior Tip: Strategy vs State
- **Strategy**: The client (you) chooses which strategy to use.
- **State**: The context (the object itself) changes its behavior based on its internal state.
