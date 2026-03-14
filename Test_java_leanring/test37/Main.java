package Test_java_leanring.test37;

import java.time.LocalDate;

/** test37 - LocalDate */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test37: LocalDate ===");
        LocalDate d = LocalDate.now();
        System.out.println(d + " " + d.getYear());
    }
}
