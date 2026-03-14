package Test_java_leanring.test86;

import java.time.Duration;
import java.time.Instant;

/** test86 - Duration */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test86: Duration ===");
        Duration d = Duration.ofSeconds(90);
        System.out.println(d.toMinutes());
    }
}
