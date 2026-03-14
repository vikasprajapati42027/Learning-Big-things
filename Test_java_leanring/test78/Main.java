package Test_java_leanring.test78;

/** test78 - labeled break */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== test78: labeled break ===");
        outer: for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (j == 1) break outer;
                System.out.println(i + "," + j);
            }
        }
    }
}
