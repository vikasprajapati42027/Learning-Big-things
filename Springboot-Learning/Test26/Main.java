package Test26;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.lang.annotation.*;

/**
 * Custom Validation:
 * Sometimes @NotBlank is not enough. You want to check your own business rules.
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

/**
 * 1. Define the Annotation
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CourseCodeValidator.class)
@Documented
@interface CourseCode {
    String value() default "LUV";
    String message() default "must start with LUV";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

/**
 * 2. Define the Logic
 */
class CourseCodeValidator implements jakarta.validation.ConstraintValidator<CourseCode, String> {
    private String coursePrefix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePrefix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String code, jakarta.validation.ConstraintValidatorContext context) {
        if (code == null) return false;
        return code.startsWith(coursePrefix);
    }
}

/**
 * 3. Use it in a DTO
 */
class StudentRequest {
    @CourseCode(value = "CS", message = "Invalid CS course code")
    private String course;
}
