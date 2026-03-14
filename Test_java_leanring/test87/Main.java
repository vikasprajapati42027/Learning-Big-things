package Test_java_leanring.test87;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

/** test87 - DateTimeFormatter */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test87: DateTimeFormatter ===");
        System.out.println(LocalDate.now().format(DateTimeFormatter.ISO_DATE));
    }
}
