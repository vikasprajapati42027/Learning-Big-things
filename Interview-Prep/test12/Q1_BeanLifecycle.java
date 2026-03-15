/**
 * INTERVIEWER: Explain the Spring Bean Lifecycle.
 * CANDIDATE: Bean lifecycle consists of several phases: Instantiate, Populate Properties, 
 * Name/Factory/Context Aware, Post-Process, Init, and Destroy.
 */
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

class MyBean {
    private String name;
    private String contextInfo;

    public MyBean() {
        System.out.println("1. Bean Instantiation");
    }

    void setBeanName(String name) {
        this.name = name;
        System.out.println("2. BeanNameAware: assigned bean name -> " + name);
    }

    void setApplicationContext(String contextInfo) {
        this.contextInfo = contextInfo;
        System.out.println("3. ApplicationContextAware: context -> " + contextInfo);
    }

    @PostConstruct
    public void init() {
        System.out.println("4. Bean Initialization (@PostConstruct)");
    }

    public void doWork() {
        System.out.println("5. Bean is in Use [" + name + " under " + contextInfo + "]");
    }

    @PreDestroy
    public void cleanup() {
        System.out.println("6. Bean Cleanup (@PreDestroy)");
    }
}

class BeanContainerSimulator {
    private final MyBean bean;

    BeanContainerSimulator(MyBean bean) {
        this.bean = bean;
    }

    void start() {
        System.out.println("== Container: preparing bean ==");
        bean.setBeanName("demoBean");
        bean.setApplicationContext("InterviewContext");
        bean.init();
        bean.doWork();
    }

    void shutdown() {
        System.out.println("== Container: destroying bean ==");
        bean.cleanup();
    }
}

public class Q1_BeanLifecycle {
    public static void main(String[] args) {
        System.out.println("Spring Container simulation for Bean Lifecycle:");
        BeanContainerSimulator container = new BeanContainerSimulator(new MyBean());
        container.start();
        container.shutdown();
    }
}
