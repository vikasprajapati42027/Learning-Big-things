/**
 * INTERVIEWER: Let's discuss Advanced Topic in Module 17.
 * 
 * CANDIDATE: Advanced Topic in Module 17 is a critical aspect of modern Java engineering. 
 * I have implemented several systems leveraging this to achieve high performance.
 *
 * PROPER EXPLANATION:
 * 1. Introduction to Advanced Topic in Module 17 and its architectural impact.
 * 2. Implementation details in a production environment.
 * 3. Handling concurrency and edge cases in Advanced Topic in Module 17.
 */
import java.util.*;
import java.util.function.Function;

class ApiRequest {
    final String path;
    final Map<String, String> headers;

    ApiRequest(String path, Map<String, String> headers) {
        this.path = path;
        this.headers = headers;
    }
}

class ApiResponse {
    final int status;
    final String body;

    ApiResponse(int status, String body) {
        this.status = status;
        this.body = body;
    }

    @Override
    public String toString() {
        return "ApiResponse{status=" + status + ", body='" + body + "'}";
    }
}

class Pipeline {
    private final List<Function<ApiRequest, ApiResponse>> middlewares = new ArrayList<>();

    void addMiddleware(Function<ApiRequest, ApiResponse> middleware) {
        middlewares.add(middleware);
    }

    ApiResponse execute(ApiRequest request) {
        for (Function<ApiRequest, ApiResponse> middleware : middlewares) {
            ApiResponse response = middleware.apply(request);
            if (response != null) {
                return response;
            }
        }
        return new ApiResponse(404, "No handler matched");
    }
}

public class Q1_Main {
    public static void main(String[] args) {
        System.out.println("--- Interview Prep Masterclass: Advanced Topic in Module 17 ---");
        System.out.println("Executing Scenario for Module 17...");
        runScenario();
    }

    public static void runScenario() {
        Pipeline pipeline = new Pipeline();
        pipeline.addMiddleware(request -> {
            if (!"token-123".equals(request.headers.get("Authorization"))) {
                return new ApiResponse(401, "Unauthorized");
            }
            return null;
        });
        pipeline.addMiddleware(request -> {
            if ("/payments".equals(request.path)) {
                return new ApiResponse(200, "Payment service response");
            }
            return null;
        });
        ApiRequest request = new ApiRequest("/payments", Map.of("Authorization", "token-123"));
        ApiResponse response = pipeline.execute(request);
        System.out.println("Pipeline result: " + response);
        System.out.println("Module 17 advanced topic executed with senior-level precision.");
    }
}
