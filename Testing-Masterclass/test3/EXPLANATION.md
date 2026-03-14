# Test 3: @DataJpaTest — Repository Slice Testing

## Simple Explanation
Tests ONLY your JPA repositories using an in-memory H2 database.
No web layer, no service layer — just the database interaction.

## Example
```java
@DataJpaTest
class UserRepositoryTest {

    @Autowired
    UserRepository repo;

    @Test
    void testFindByEmail() {
        // Given
        repo.save(new User("Vikas", "vikas@mail.com"));

        // When
        Optional<User> found = repo.findByEmail("vikas@mail.com");

        // Then
        assertTrue(found.isPresent());
        assertEquals("Vikas", found.get().getName());
    }
}
```

## What @DataJpaTest starts:
✅ JPA repositories
✅ Entity classes
✅ H2 in-memory database
✅ Hibernate/schema creation
❌ Controllers (not needed)
❌ Services (not needed)
❌ External configs

## TestEntityManager
Gives you more control than repository for test setup:
```java
@Autowired TestEntityManager entityManager;
entityManager.persistAndFlush(new User("Rahul", "rahul@mail.com"));
```
