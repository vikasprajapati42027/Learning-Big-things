# Test 3: Layered Architecture

This module explains the standard way to organize code in a Spring Boot application using "Layers".

## 1. Why Layers?
Instead of putting all your code in one place, we split it into layers with specific responsibilities. This is called **Separation of Concerns**.

## 2. The Layers used in this project:

### Data Access Layer (`@Repository`)
- **Class**: `UserRepository.java`
- **Job**: Fetch data from a source (Database, File, External API).
- **Benefit**: If you change your database type, you only need to change the Repository.

### Business Logic Layer (`@Service`)
- **Class**: `UserService.java`
- **Job**: Process data, perform calculations, and enforce rules.
- **Benefit**: This keeps your business rules central and reusable.

### Application Layer (`@SpringBootApplication` / Main)
- **Class**: `Main.java`
- **Job**: Start the app and coordinate the flow.

## 3. Why not just `@Component`?
While `@Component` works, using `@Repository` and `@Service` provides:
1. **Clarity**: Other developers instantly know the purpose of the class.
2. **Special Features**: 
   - `@Repository` enables automatic exception translation (converts database errors into Spring's readable exceptions).
   - `@Service` is often used to target specific "Aspects" like Transaction Management.

## How it works:
1. `Main` (App Layer) starts.
2. It asks `UserService` (Logic Layer) for users.
3. `UserService` asks `UserRepository` (Data Layer) for raw data.
4. `UserService` processes the raw data (converts to UPPERCASE).
5. `Main` displays the results.
