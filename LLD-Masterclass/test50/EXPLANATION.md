# Test 50: The Final LLD Challenge (Locker System)

## 🏆 1. The Problem
Design an **Amazon Locker System**.
- Lockers come in 3 sizes: Small, Medium, Large.
- Packages come in 3 sizes.
- A package can only fit in a locker of the same or larger size.
- A user gets a 4-digit code to open the locker.

## 🚀 2. How to solve using Patterns?
1. **Strategy**: Use it for "Locker Assignment" logic (Nearest first vs random).
2. **State**: Locker can be `EMPTY`, `BOOKED`, `CLOSED_WITH_PACKAGE`.
3. **Singleton**: Use for the `LockerManager` to ensure only one system controls the locks.
4. **Observer**: Notify the customer via SMS/Email when the package is delivered.

---

## 🏁 Final Mastery Tip:
Design Patterns are **Tools**, not Rules. Don't start with a pattern; start with the **Problem**. If the problem is "too many if-else," use Strategy. If the problem is "memory usage," use Flyweight. 

Congratulations, you are now an LLD Expert! 🚀
