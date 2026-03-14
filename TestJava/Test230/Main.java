package TestJava.Test230;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 230: JLink & Custom JRE Creation Concept ===\n");

        System.out.println("Before Java 9, your app required the FULL Java Runtime Environment (JRE) (~200MB).");
        System.out.println("Even if your app was an incredibly small 1MB HelloWorld program,");
        System.out.println("you still needed 200MB of java.sql, java.desktop, rmi, CORBA, etc.\n");

        System.out.println("Java 9 Modules (JPMS) fixed this!");
        System.out.println("Now, Java itself is split into ~75 modules (java.base, java.logging, java.xml).\n");

        System.out.println("--- JLink (The Java Linker) ---");
        System.out.println("JLink allows you to create a completely custom, minimal JRE that ONLY contains");
        System.out.println("the modules your application actually uses!\n");

        System.out.println("Example:");
        System.out.println("   Your app uses 'java.base' and 'java.logging'.");
        System.out.println("   Command: jlink --add-modules java.base,java.logging --output custom-jre");
        
        System.out.println("\nResult:");
        System.out.println("   The 'custom-jre' folder is only ~35MB!");
        System.out.println("   You zip this up with your 1MB app and ship it to Docker or a client.");
        System.out.println("   They don't even need Java installed on their machine! They just run:");
        System.out.println("      ./custom-jre/bin/java -m myapp/com.vikasp.Main\n");

        System.out.println("This is highly recommended for building incredibly small Docker images (e.g. Alpine + JLink).");
    }
}
