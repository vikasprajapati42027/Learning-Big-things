package Test2;

import org.springframework.stereotype.Component;

/**
 * @Component is a generic stereotype for any Spring-managed component.
 * When Spring scans the package, it will find this class and create a 
 * "Bean" instance of it in the IoC Container.
 */
@Component
public class GreetingService {

    public String getGreeting() {
        return "Hello from the Spring-managed GreetingService Bean!";
    }
}
