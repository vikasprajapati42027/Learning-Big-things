package Test10;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidationController {

    /**
     * @Valid triggers the validation annotations in UserRequest.
     * If validation fails, MethodArgumentNotValidException is thrown.
     */
    @PostMapping("/users")
    public String createUser(@Valid @RequestBody UserRequest user) {
        return "User " + user.getName() + " created successfully!";
    }
}
