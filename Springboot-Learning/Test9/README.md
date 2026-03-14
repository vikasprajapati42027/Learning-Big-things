# Test 9: Spring Bean Scopes & Lifecycle

This module explains how Spring manages instances of your classes and their "life" stages.

## 1. Bean Scopes

| Scope | Description | Use Case |
| :--- | :--- | :--- |
| **Singleton** (Default) | Only one instance is created. Everyone gets the same object. | Statless services, Repositories, Configs. |
| **Prototype** | A new instance is created every time it's requested. | Stateful objects like a user shopping cart. |

## 2. Lifecycle Annotations

Sometimes you need to run some code when a bean is "born" or right before it "dies".

- **`@PostConstruct`**: Runs after the constructor and after all dependencies (via `@Autowired`) are injected. Perfect for initializing data.
- **`@PreDestroy`**: Runs right before the bean is removed from the container (app shutdown). Used for closing database connections or clearing cache.

---

## 3. Check Your Understanding (Quiz)

**Question 1:** If you have 5 different classes that all `@Autowired` a `DatabaseService` bean, how many instances of `DatabaseService` will Spring create by default?
1. 1 (Singleton)
2. 5 (Prototype)
3. 0

**Question 2:** You need to fetch some temporary data from an API as soon as your Bean is ready. Which annotation should you use for that method?
1. `@PreDestroy`
2. `@PostConstruct`
3. `@Autowired`

**Question 3:** Does Spring manage the destruction of "Prototype" beans?
- *Hint: Research "Prototype bean lifecycle" - it's a famous Spring interview question!*

---

## How it works in this code:
1. `SingletonBean` is created once. Notice the `identityHashCode` is the same in the output.
2. `PrototypeBean` is created twice because we asked for it twice. Notice the different HashCodes!
3. `@PostConstruct` prints as soon as the app starts.
4. `@PreDestroy` prints when the application stops.
