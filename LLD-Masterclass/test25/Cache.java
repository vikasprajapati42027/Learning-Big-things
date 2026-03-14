import java.util.ArrayList;
import java.util.List;

public class Cache {
    private List<Service> services = new ArrayList<>();

    public Service getService(String serviceName) {
        for (Service service : services) {
            if (service.getName().equalsIgnoreCase(serviceName)) {
                System.out.println("Returning cached service: " + serviceName);
                return service;
            }
        }
        return null;
    }

    public void addService(Service newService) {
        services.add(newService);
    }
}
