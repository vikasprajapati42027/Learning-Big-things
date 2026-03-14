import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class Test15_AssertJ {
    @Test
    void testFluentAssertions() {
        List<String> fruits = List.of("Apple", "Banana", "Cherry");

        // AssertJ is much more readable than standard JUnit assertions
        assertThat(fruits)
            .hasSize(3)
            .contains("Apple")
            .doesNotContain("Mango")
            .startsWith("Apple")
            .endsWith("Cherry");
    }
}
