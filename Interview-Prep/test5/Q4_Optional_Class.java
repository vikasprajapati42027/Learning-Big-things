/**
 * Interviewer: Purpose of Optional?
 * Candidate: To avoid NullPointerException by providing a wrapper that might or might not contain value.
 */
import java.util.Optional;
public class Q4_Optional_Class {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);
        System.out.println(name.orElse("Guest"));
    }
}
