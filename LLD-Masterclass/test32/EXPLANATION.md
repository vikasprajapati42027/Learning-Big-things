# Test 32: SOLID - I (Interface Segregation Principle)

## 📎 1. What is ISP? (Simple Explanation)
ISP means **"A client should never be forced to depend on methods it does not use."**
Imagine you go to a **Cafe** that only sells a "Mega Combo" (Pizza + Burger + Coke + Fries). 
- If you only want a Coke, you still have to pay for the whole combo. That's a bad interface! 
A good cafe lets you buy **exactly** what you need.

---

## 🖱️ 2. Coding Examples

### The Wrong Way:
Creating a giant `SmartDevice` interface with `print()`, `scan()`, `fax()`, and `call()`.
- If you build a simple "Old Printer," you are forced to write `fax() { throw Exception; }`. This is ugly and confusing.

### The Right Way:
Split the giant interface into small, specific ones:
- `Printable`
- `Scannable`
- `Faxable`
Your "Old Printer" only implements `Printable`. Your "Super Office Machine" implements all three.

---

## 🚀 3. Why use this?
1. **Lean Classes**: Objects don't carry "dead weight" methods they don't need.
2. **Maintenance**: If the `fax()` logic changes, you don't even need to look at the `OldPrinter` code.
