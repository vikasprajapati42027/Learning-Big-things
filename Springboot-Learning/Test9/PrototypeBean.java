package Test9;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Prototype scope means a NEW instance is created 
 * EVERY TIME the bean is requested from the container.
 */
@Component
@Scope("prototype")
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("PrototypeBean: Constructor called (New Instance).");
    }

    public void sayHello() {
        System.out.println("PrototypeBean: Hello! My ID is " + System.identityHashCode(this));
    }
}
