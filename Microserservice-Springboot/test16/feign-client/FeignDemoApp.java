import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@EnableFeignClients
public class FeignDemoApp {
    public static void main(String[] args) { SpringApplication.run(FeignDemoApp.class, args); }
}

@FeignClient(name = "user-service", url = "http://localhost:8081")
interface UserClient {
    @GetMapping("/users/profile")
    String getProfile();
}
