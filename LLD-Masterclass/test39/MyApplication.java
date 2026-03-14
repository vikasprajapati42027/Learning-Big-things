public class MyApplication {
    private MessageService service;

    // Dependency is "Injected" via Constructor
    public MyApplication(MessageService svc) {
        this.service = svc;
    }

    public void process(String msg) {
        service.send(msg);
    }
}
