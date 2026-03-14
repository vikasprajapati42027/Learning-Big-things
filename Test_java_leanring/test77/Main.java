package Test_java_leanring.test77;

/** test77 - break, continue */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test77: break continue ===");
        for (int i = 0; i < 5; i++) {
            if (i == 2) continue;
            if (i == 4) break;
            System.out.println(i);
        }
    }
}
