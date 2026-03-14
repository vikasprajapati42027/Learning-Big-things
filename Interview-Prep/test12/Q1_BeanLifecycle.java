/**
 * INTERVIEWER: Explain the Spring Bean Lifecycle.
 * CANDIDATE: Bean lifecycle consists of several phases: Instantiate, Populate Properties, 
 * Name/Factory/Context Aware, Post-Process, Init, and Destroy.
 */
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

class MyBean {
    public MyBean() { System.out.println("1. Bean Instantiation"); }
    
    @PostConstruct
    public void init() { System.out.println("2. Bean Initialization (@PostConstruct)"); }
    
    public void doWork() { System.out.println("3. Bean is in Use"); }
    
    @PreDestroy
    public void cleanup() { System.out.println("4. Bean Cleanup (@PreDestroy)"); }
}

public class Q1_BeanLifecycle {
    public static void main(String[] args) {
        System.out.println("Spring Container simulation for Bean Lifecycle:");
        MyBean bean = new MyBean();
        bean.init();
        bean.doWork();
        bean.cleanup();
    }
}
