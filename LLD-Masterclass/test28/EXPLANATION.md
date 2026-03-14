# Test 28: MVC (Model-View-Controller) Pattern

## 🏗️ 1. What is MVC? (Simple Explanation)
MVC is the most famous pattern in web development.
1. **Model**: The **Data** (The chef's pantry).
2. **View**: The **UI** (The menu cards and table setting).
3. **Controller**: The **Brain** (The Waiter).
The Waiter (Controller) takes your order (Input), goes to the Kitchen (Model) to get the data, and then decides how it should look on the Plate (View).

---

## 🖱️ 2. Beginner's Step-by-Step Code Walkthrough

### Step 1: The Model (`Course.java`)
- Just data fields. No logic for printing or API calls.

### Step 2: The View (`CourseView.java`)
- Only handle printing/display. It doesn't know *where* the data came from.

### Step 3: The Controller (`CourseController.java`)
- This maps the data to the view. 
- If you change the Model's logic, the View doesn't need to change.

---

## 🚀 3. Why use this?
1. **Parallel Development**: One person can work on the UI while another works on the Database.
2. **Reusability**: You can use the same Model (Course data) for a Web View and a Mobile App View.

## ⚠️ 4. Senior Tip: Modern MVC
In modern apps, "MVC" is split!
- **Model & Controller** live on the Backend (Spring Boot).
- **View** lives on the Frontend (React / Angular).
