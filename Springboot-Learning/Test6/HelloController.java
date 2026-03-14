package Test6;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RestController is a specialized version of @Controller.
 * It combines @Controller and @ResponseBody.
 * This means every method returns data (like JSON or String) directly 
 * to the HTTP response, instead of looking for a HTML template.
 */
@RestController
public class HelloController {

    /**
     * @GetMapping maps HTTP GET requests to this method.
     * When you visit http://localhost:8080/hello, this runs.
     */
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World! This is your first REST endpoint.";
    }

    /**
     * When returning an object, Spring automatically converts it to JSON.
     * Try visiting http://localhost:8080/user
     */
    @GetMapping("/user")
    public UserResponse getUser() {
        return new UserResponse("Vikas", "Java Developer");
    }
}
