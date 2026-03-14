# Test 12: Composite Design Pattern (Structural)

## 🌳 1. What is the Composite Pattern? (Simple Explanation)
Imagine a **File System**.
- You have **Files** (Single items).
- You have **Folders** (Containers that hold files OR other folders).
Even though a folder is bigger, you want to treat it as a "thing" just like a file (e.g., both can be Deleted, copied, or Moved).
The Composite pattern allows you to treat "Individual objects" and "Groups of objects" in the **exact same way**.

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Base Interface (`FileComponent.java`)
- Every item (File or Folder) must have a `showDetails()` method.

### Step 2: The Leaf (`File.java`)
- This is the final item. It doesn't contain anything else. It just prints its own name.

### Step 3: The Composite (`Folder.java`)
- This is the "Box." It contains a **List** of other items.
- Because it holds `FileComponent` objects, it can store both Files AND other Folders inside it!
- When you call `showDetails()` on a folder, it tells all its children to show their details.

### Step 4: The Result (`CompositeDemo.java`)
- You build a tree structure (Files inside Folders inside Folders).
- In the end, you just call `root.showDetails()`, and the whole tree prints perfectly.

---

## 🚀 3. Why use this?
1. **Tree Structures**: Perfect for UI Menus, File Systems, or Organization Charts (Manager -> Employee).
2. **Uniformity**: The client doesn't need to know if it's talking to a single pixel or a whole image.

## ⚠️ 4. Senior Tip: Part-Whole Hierarchy
Whenever you see a "Tree" or "Parent-Child" relationship where the Parent and Child need similar behavior, **Composite** is the answer.
