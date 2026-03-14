package TestJava.Test128;

import java.io.File;
import java.nio.file.Files;

// A custom ClassLoader can load classes from ANYWHERE: a database, the network, 
// a custom encrypted file, or a byte array dynamically generated at runtime!
class NetworkClassLoader extends ClassLoader {
    
    // Override findClass to intercept class loading
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // We will simulate finding a .class file by just loading an existing one locally.
        // In a real scenario, this byte array could come from an HTTP request!
        try {
            // Convert "TestJava.Test5.Main" to "TestJava/Test5/Main.class"
            String filePath = name.replace('.', File.separatorChar) + ".class";
            File f = new File(filePath);
            
            if (!f.exists()) {
                throw new ClassNotFoundException(name);
            }
            
            byte[] classBytes = Files.readAllBytes(f.toPath());
            
            System.out.println("[CustomLoader] Loading class directly from bytes: " + name);
            
            // defineClass converts the raw byte array into a real java.lang.Class object!
            return defineClass(name, classBytes, 0, classBytes.length);
            
        } catch (Exception e) {
            throw new ClassNotFoundException(name, e);
        }
    }
}

class Dummy {
    public void sayHi() {
        System.out.println("Hello from dynamically loaded Dummy class!");
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Custom ClassLoader ===\n");

        System.out.println("Instantiating Custom ClassLoader...");
        NetworkClassLoader customLoader = new NetworkClassLoader();

        // Let's attempt to load an existing class through our custom loader!
        // (We choose Test128.Dummy because we know it exists)
        String targetClass = "TestJava.Test128.Dummy";
        System.out.println("Attempting to load: " + targetClass);
        
        Class<?> dynamicClass = customLoader.loadClass(targetClass);
        
        System.out.println("\nLoaded Class: " + dynamicClass.getName());
        System.out.println("Was it loaded by our custom loader? " + 
                (dynamicClass.getClassLoader() == customLoader));
                
        // Note: Standard JVM classes (java.lang.String) are never loaded by custom loaders 
        // due to the 'Parent Delegation Model' which defers to the bootstrap loader first!
    }
}
