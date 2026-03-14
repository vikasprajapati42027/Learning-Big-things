import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

// Test 1: JUnit 5 Features
public class Test1_JUnit5 {

    @Test
    void basicTest() {
        assertEquals(4, 2 + 2, "Math should work");
        assertNotNull("hello", "Should not be null");
        assertTrue("Vikas".startsWith("V"), "Should start with V");
    }

    @ParameterizedTest
    @CsvSource({"2, 3, 5", "10, 20, 30", "0, 0, 0"})
    void additionTest(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

    @Test
    @DisplayName("User age must not be negative")
    void negativeAgeTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            if (-1 < 0) throw new IllegalArgumentException("Age cannot be negative");
        });
    }

    @Nested
    @DisplayName("String operations")
    class StringTests {
        @Test void shouldUpperCase() { assertEquals("VIKAS", "vikas".toUpperCase()); }
        @Test void shouldTrim() { assertEquals("hello", "  hello  ".trim()); }
    }

    @Test @Disabled("Not implemented yet")
    void futureTest() { fail("This test is pending"); }
}
