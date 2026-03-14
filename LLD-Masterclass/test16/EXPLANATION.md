# Test 16: Iterator Design Pattern (Behavioral)

## 🚶 1. What is the Iterator Pattern? (Simple Explanation)
Imagine you have a **Box of Photos**.
- You want to see every photo, one by one.
- You don't want to know how they are stored (Are they in a stack? A circle? A list?).
The Iterator is like a **Hand** that reaches into the box and gives you the "Next" item until the box is empty.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Iterator Interface (`Iterator.java`)
- Defines `hasNext()` (Are there more items?) and `next()` (Give me the item).

### Step 2: The Container Interface (`Container.java`)
- Every collection that wants to be "Iteratable" must provide an iterator.

### Step 3: The Repository (`NameRepository.java`)
- It holds an internal array of names.
- It has a "Private Inner Class" `NameIterator`. 
- This inner class knows how to move through the array without exposing the array itself to the outside world.

### Step 4: The Result (`IteratorDemo.java`)
- We loop through the repository using the iterator. Note that we never access the `names[]` array directly!

---

## 🚀 3. Why use this?
1. **Encapsulation**: You hide the complex internal structure (Tree, Hashmap, Graph) from the user.
2. **Simplified Interface**: The user only needs to know `hasNext()` and `next()`.
3. **Multiple Traversals**: You can have two different iterators on the same collection at once.

## ⚠️ 4. Senior Tip: Java Collections
All Java collections (List, Set, Map) use the Iterator pattern. When you use the "Enhanced For Loop" `for(String s : list)`, Java is actually using an Iterator under the hood!
