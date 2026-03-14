package Test7;

import org.springframework.web.bind.annotation.*;

/**
 * Demonstrating different ways to receive input from the user.
 */
@RestController
@RequestMapping("/api")
public class InputController {

    /**
     * 1. @PathVariable
     * Used for values that are part of the URL path itself.
     * Example: http://localhost:8080/api/user/123
     */
    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable("id") String userId) {
        return "Received Path Variable - User ID: " + userId;
    }

    /**
     * 2. @RequestParam
     * Used for query parameters (after the ? in the URL).
     * Example: http://localhost:8080/api/search?query=iphone
     */
    @GetMapping("/search")
    public String search(@RequestParam(name = "query", defaultValue = "nothing") String query) {
        return "Received Request Parameter - Search Query: " + query;
    }

    /**
     * 3. @RequestBody
     * Used for receiving large amounts of data, usually in JSON format (POST requests).
     * Since we aren't using a real client, imagine sending a JSON to this endpoint.
     */
    @PostMapping("/product")
    public String createProduct(@RequestBody ProductRequest product) {
        return "Received Request Body - Product: " + product.getName() + " with Price: " + product.getPrice();
    }
}
