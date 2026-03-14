# Test 46: Lazy Loading

## 💤 1. Simple Explanation
Imagine you open an **Instagram profile**. 
- **Eager Loading**: The app downloads all 5,000 photos the user ever posted immediately. (Slow and wastes data).
- **Lazy Loading**: The app only downloads the first 10. It downloads more ONLY when you scroll down.
In LLD, we only load data from the database when it is actually accessed.
