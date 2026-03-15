/**
 * Interviewer: Explain API_Gateway Concept 2.
 * Candidate: Professional detailed answer regarding API_Gateway 2.
 * 
 * Key Highlights: Routing, Authentication, Rate Limiting
 */
import java.util.Optional;

public class Q2_API_Gateway {
    public void demo() {
        Optional<String> token = Optional.ofNullable(getHeader("Authorization"));
        if (token.filter(t -> t.startsWith("Bearer ")).isPresent()) {
            System.out.println("Authentication filter passed, token = " + token.get());
        } else {
            System.out.println("Authentication filter blocked the request.");
        }
    }

    private String getHeader(String name) {
        if ("Authorization".equals(name)) {
            return "Bearer abc123";
        }
        return null;
    }
}
