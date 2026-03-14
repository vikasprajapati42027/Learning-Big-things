# Test 8: Data Persistence with Spring Data JPA

This module explains how to talk to a database without writing SQL.

## 1. What is ORM?
**ORM (Object-Relational Mapping)** is a technique that lets you query and manipulate data from a database using an object-oriented paradigm.
- **Object Layer**: Java Classes (`User.java`).
- **Relational Layer**: Database Tables (`users` table).
- **The Mapper**: JPA/Hibernate (Connects the two).

## 2. Key JPA Annotations

| Annotation | Purpose |
| :--- | :--- |
| `@Entity` | Tells Spring this class represents a database table. |
| `@Id` | Marks the primary key (unique ID). |
| `@GeneratedValue` | Automatically generates the ID value (like auto-increment). |
| `@Table` | Specifies the exact table name in the database. |

## 3. The Magic of `JpaRepository`
In standard Java, you would write many lines of JDBC/SQL code to save a user. With Spring Data JPA, you just create an interface:
```java
public interface UserRepository extends JpaRepository<User, Long> {}
```
Spring then gives you `save()`, `findAll()`, `findById()`, and `delete()` for free!

---

## 4. Check Your Understanding (Quiz)

**Question 1:** Which annotation is used to tell Spring that a class name `Student` should be treated as a database table?
1. `@Component`
2. `@Entity`
3. `@Repository`

**Question 2:** If you want Spring to automatically handle the primary key (ID) for you, which annotation do you use along with `@Id`?
1. `@GeneratedValue`
2. `@AutoGenerate`
3. `@Table`

**Question 3:** What is the main benefit of using `JpaRepository`?
- *Think about how much code you avoided writing.*

---

## How it works:
1. When the app starts, Spring scans for `@Entity` classes and creates the database schema (if configured).
2. It detects the `UserRepository` interface and creates an implementation for it at runtime.
3. When you call `repository.save(user)`, JPA converts that Java object into an `INSERT` SQL statement.
