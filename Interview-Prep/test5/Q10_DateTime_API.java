/**
 * Interviewer: Why Java 8 Date-Time API (java.time)?
 * Candidate: Older Date/Calendar classes were mutable and not thread-safe. LocalDateTime is immutable and thread-safe.
 */
import java.time.LocalDateTime;
public class Q10_DateTime_API {
    public static void main(String[] args) {
        System.out.println(LocalDateTime.now());
    }
}
