# Test 2: Observer Design Pattern (Behavioral)

## 📡 1. What is the Observer Pattern? (Simple Explanation)
Imagine you follow a **YouTube Channel**.
- You (The **Observer**) want to know when a new video is uploaded.
- The Channel (The **Subject**) keeps a list of all subscribers.
- When the video is uploaded, the Channel "Notifies" everyone in that list automatically.
This is also called **Publisher-Subscriber** model.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Subject (`Subject.java`)
- This is the "Channel." It maintains a `List<Observer>`.
- When its `state` changes, it loops through the list and calls `.update()` on everyone.

### Step 2: The Observer Contract (`Observer.java`)
- Every subscriber must have an `update()` method so the Subject knows what to call.

### Step 3: Concrete Observers (`HexObserver.java`, `BinaryObserver.java`)
- These are the actual subscribers. 
- One subscriber might want to see numbers in Hex.
- Another might want to see them in Binary.
- They both "attach" themselves to the Subject upon creation.

### Step 4: The Result (`ObserverDemo.java`)
- We change the state *once* in the Subject, and multiple observers react instantly!

---

## �� 3. Why use this?
1. **Automatic Updates**: You don't have to manually tell 10 different objects that something changed.
2. **Decoupling**: The Subject doesn't need to know the details of the Observers; it just knows they have an `update()` method.

## ⚠️ 4. Senior Tip: Memory Leaks
If you attach an observer but forget to "Detach" it when it's no longer needed, the Subject will keep a reference to it forever. This is a common cause of **Memory Leaks** in Java. Always implement a `detach()` method in production!
