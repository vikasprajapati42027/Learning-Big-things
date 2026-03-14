package Test9;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private ApplicationContext context;

    public static void main(String[] args) {
        System.out.println("Starting Test 9: Bean Scopes & Lifecycle...");
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("\n--- Testing Singleton Scope ---");
        SingletonBean s1 = context.getBean(SingletonBean.class);
        SingletonBean s2 = context.getBean(SingletonBean.class);
        s1.sayHello();
        s2.sayHello();
        System.out.println("Are s1 and s2 the same? " + (s1 == s2));

        System.out.println("\n--- Testing Prototype Scope ---");
        PrototypeBean p1 = context.getBean(PrototypeBean.class);
        PrototypeBean p2 = context.getBean(PrototypeBean.class);
        p1.sayHello();
        p2.sayHello();
        System.out.println("Are p1 and p2 the same? " + (p1 == p2));
        
        System.out.println("\n--- App finishing (check for @PreDestroy) ---");
    }
}
