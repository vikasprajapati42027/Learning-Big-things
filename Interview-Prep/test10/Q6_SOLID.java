/**
 * INTERVIEWER: SOLID Principle Scenario 6.
 * CANDIDATE: Professional implementation of SOLID principle 6.
 */
class Resource {
    private final String name;

    Resource(String name) {
        this.name = name;
    }

    void use() {
        System.out.println("Using resource: " + name);
    }
}

class ResourceManager {
    private final Resource resource;

    ResourceManager(Resource resource) {
        this.resource = resource;
    }

    void execute() {
        resource.use();
    }
}

public class Q6_SOLID {
    public static void main(String[] args) {
        ResourceManager manager = new ResourceManager(new Resource("Database Connection"));
        manager.execute();
    }
}
