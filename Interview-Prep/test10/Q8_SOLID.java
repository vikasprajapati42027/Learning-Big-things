/**
 * INTERVIEWER: SOLID Principle Scenario 8.
 * CANDIDATE: Professional implementation of SOLID principle 8.
 */
class Validator {
    boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }
}

class RegistrationService {
    private final Validator validator;

    RegistrationService(Validator validator) {
        this.validator = validator;
    }

    void register(String userName) {
        if (validator.isValid(userName)) {
            System.out.println(userName + " registered successfully.");
        } else {
            System.out.println("Registration failed: invalid name.");
        }
    }
}

public class Q8_SOLID {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService(new Validator());
        service.register("Alex");
        service.register("  ");
    }
}
