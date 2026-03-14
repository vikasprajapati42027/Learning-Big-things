# Test 10: Global Error Handling & Validation

Congratulations! You've reached the final module. This lesson covers how to make your API robust by validating data and handling errors gracefully.

## 1. Data Validation
Instead of writing 10 `if` statements to check if an email is valid or a name is empty, Spring lets you use **annotations**.

- **`@NotBlank`**: Ensures a string is not empty or just whitespace.
- **`@Email`**: Checks for a valid email format.
- **`@Size`**: Enforces a minimum or maximum length.
- **`@Valid`**: Tells Spring to actually check these annotations when a request arrives.

## 2. Global Exception Handling
If validation fails, Spring throws an error. Without a handler, the user gets a messy "Internal Server Error" page.
With **`@ControllerAdvice`**, you can catch these errors and return a clean, helpful JSON message:

**Example Error Response:**
```json
{
  "email": "Invalid email format",
  "password": "Password must be at least 8 characters long"
}
```

---

## 3. Final Course Quiz (Comprehensive)

**Question 1:** Which annotation combines `@Controller` and `@ResponseBody`?
1. `@RestController`
2. `@WebController`
3. `@Service`

**Question 2:** Which interface do you extend to get "zero-code" database operations?
1. `CrudTemplate`
2. `JpaRepository`
3. `SqlRepository`

**Question 3:** What is the default scope of a Spring Bean?
1. Prototype
2. Singleton
3. Request

---

## Course Wrap-Up
You have successfully built 10 modules covering:
1. `@SpringBootApplication` & Main
2. IoC & Beans (`@Component`, `@Autowired`)
3. Layered Architecture (`@Service`, `@Repository`)
4. Custom Configuration (`@Configuration`, `@Bean`)
5. External Configuration (`@Value`, `@ConfigurationProperties`)
6. REST Basics (`@RestController`, `@GetMapping`)
7. REST Inputs (`@PathVariable`, `@RequestParam`)
8. Data Persistence (JPA, `@Entity`)
9. Bean Lifecycle (`@Scope`, `@PostConstruct`)
10. Global Error Handling (`@ControllerAdvice`, `@Valid`)

**What's Next?**
- Explore **Spring Security** (Authentication/Authorization)
- Learn **Spring Cloud** (Microservices)
- Build a real project using a database like MySQL or PostgreSQL.

**Happy Coding, Vikas!**
