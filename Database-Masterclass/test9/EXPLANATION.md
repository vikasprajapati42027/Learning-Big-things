# Test 9: 50 Scenarios in Normalization & Schema Design

## 1. The Goal: Zero Redundancy
Normalization is not about making tables "small"; it's about making sure every fact is stored in **Exactly One Place**.

## 2. The 3rd Normal Form (3NF) Rule
"A column must depend on the Key (1NF), the Whole Key (2NF), and Nothing but the Key (3NF), so help me Codd!"

## 3. Real-World Trade-offs
While 3NF is great for integrity, sometimes we **Denormalize** intentionally (Test 10) to avoid slow 10-table joins. But as a Senior Developer, you must start with a clean 3NF design first.

## 4. Key Interview Design Questions
- **Many-to-Many**: "Design a system where Students can join multiple Courses and Courses have multiple Students." (Answer: Junction Table).
- **Infinite Categories**: "How do you store a folder structure where any folder can have sub-folders?" (Answer: Self-referencing Foreign Key).
- **Scale**: "What is a Surrogate Key and why use it over a Natural Key (like Email)?" (Answer: Independence from business changes).
