package Test9;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

/**
 * Singleton is the default scope in Spring.
 * Only ONE instance of this bean is created per Spring Container.
 */
@Component
public class SingletonBean {

    public SingletonBean() {
        System.out.println("SingletonBean: Constructor called.");
    }

    /**
     * @PostConstruct is called after the bean is created 
     * and dependencies are injected.
     */
    @PostConstruct
    public void init() {
        System.out.println("SingletonBean: @PostConstruct - I am alive!");
    }

    /**
     * @PreDestroy is called right before the bean is destroyed 
     * (usually when the app shuts down).
     */
    @PreDestroy
    public void cleanup() {
        System.out.println("SingletonBean: @PreDestroy - I am dying. Goodbye!");
    }

    public void sayHello() {
        System.out.println("SingletonBean: Hello! My ID is " + System.identityHashCode(this));
    }
}
