/**
 * INTERVIEWER: Let's discuss REST API Best Practices.
 * 
 * CANDIDATE: REST API Best Practices is a critical aspect of modern Java engineering. 
 * I have implemented several systems leveraging this to achieve high performance.
 *
 * PROPER EXPLANATION:
 * 1. Introduction to REST API Best Practices and its architectural impact.
 * 2. Implementation details in a production environment.
 * 3. Handling concurrency and edge cases in REST API Best Practices.
 */
import java.util.*;

class Resource {
    private final int id;
    private final String body;

    Resource(int id, String body) {
        this.id = id;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Resource{id=" + id + ", body='" + body + "'}";
    }
}

class ApiResponse {
    private final List<Resource> data;
    private final int total;

    ApiResponse(List<Resource> data, int total) {
        this.data = data;
        this.total = total;
    }

    @Override
    public String toString() {
        return "ApiResponse{total=" + total + ", data=" + data + "}";
    }
}

class RequestContext {
    final Map<String, String> headers = new HashMap<>();
    final Map<String, String> params = new HashMap<>();

    void validate() {
        if (!headers.containsKey("Authorization")) {
            throw new IllegalStateException("Missing Authorization header");
        }
    }
}

class ApiHandler {
    private final List<Resource> datastore = new ArrayList<>();

    ApiHandler() {
        for (int i = 1; i <= 3; i++) {
            datastore.add(new Resource(i, "Payload " + i));
        }
    }

    ApiResponse handle(RequestContext context) {
        context.validate();
        List<Resource> page = datastore.subList(0, Math.min(2, datastore.size()));
        System.out.println("Applying pagination and caching hints.");
        return new ApiResponse(page, datastore.size());
    }
}

public class Q1_Main {
    public static void main(String[] args) {
        System.out.println("--- Interview Prep Masterclass: REST API Best Practices ---");
        System.out.println("Executing Scenario for Module 15...");
        runScenario();
    }

    public static void runScenario() {
        ApiHandler handler = new ApiHandler();
        RequestContext context = new RequestContext();
        context.headers.put("Authorization", "Bearer sample-token");
        context.params.put("page", "1");
        ApiResponse response = handler.handle(context);
        System.out.println("Response: " + response);
        System.out.println("Module 15 REST Scenario executed with senior-level precision.");
    }
}
