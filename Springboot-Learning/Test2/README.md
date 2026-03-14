# Test 2: IoC, Beans, and Dependency Injection

This module explains how Spring manages objects and their relationships.

## 1. What is a Bean?
In Spring, a **Bean** is simply an object that is instantiated, assembled, and managed by the Spring IoC container. 
- You don't create them using `new GreetingService()`.
- Spring creates them for you when you use annotations like `@Component`, `@Service`, or `@Repository`.

## 2. Inversion of Control (IoC)
**IoC** is a design principle where the control of object creation and lifecycle is transferred from the developer to a container (the Spring Framework).
- Instead of the programmer being in control of when a class is instantiated, Spring takes that responsibility.

## 3. Dependency Injection (DI)
**DI** is a pattern through which IoC is implemented. It's the process where the container "injects" the required dependencies into a class at runtime.
- We use the `@Autowired` annotation to tell Spring: "I need an instance of this class, please give it to me."

## Key Annotations in this Example

| Annotation | Purpose |
| :--- | :--- |
| `@Component` | Marks a class as a Spring Bean so the container can detect it. |
| `@Autowired` | Automatically injects a bean into a field, constructor, or setter. |

## How it works in this code:
1. Spring starts and scans the package.
2. It finds `@Component` on `GreetingService` and creates a Bean.
3. It finds `@Component` on `AppRunner`.
4. It sees `@Autowired` in `AppRunner` for `GreetingService` and "injects" the previously created bean into that field.
5. `AppRunner.run()` executes, using the injected service.
