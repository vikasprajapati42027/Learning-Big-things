package TestJava.Test63;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Multiline Strings (Text Blocks) Tutorial ===\n");

        // Before Java 15: We had to use string concatenation and explicit newlines (\n)
        String oldHtml = "<html>\n" +
                         "    <body>\n" +
                         "        <p>Hello, World!</p>\n" +
                         "    </body>\n" +
                         "</html>";
                         
        System.out.println("--- 1. Old Way ---");
        System.out.println(oldHtml);

        // --- Java 15+ Text Blocks ---
        // Uses ``` (three double quotes) to start and end.
        // It PRESERVES indentation relative to the opening characters!
        String newHtml = """
                         <html>
                             <body>
                                 <p>Hello, Modern Java!</p>
                             </body>
                         </html>
                         """;

        System.out.println("\n--- 2. Text Blocks ---");
        System.out.println(newHtml);
        
        // --- 3. Escaping in Text Blocks ---
        // \  -> Suppresses the automatic newline at the end of a line
        // \s -> Forces a literal space character to be kept (prevents trailing space removal)
        String formatting = """
                            This is a really long sentence that I want to \
                            continue on the exact same line even though I \
                            broke it up in the code for readability.
                            """;
        System.out.println("\n--- 3. Suppressing Newlines ---");
        System.out.println(formatting);
    }
}
