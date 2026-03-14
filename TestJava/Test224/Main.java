package TestJava.Test224;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

class GuardedVault {
    // Private! No setters!
    private int secretCode = 1234;
    
    // A constructor that throws an error if anyone tries to call it!
    public GuardedVault() {
        throw new RuntimeException("ACCESS DENIED: You cannot instantiate this vault!");
    }
    
    public int getSecretCode() { return secretCode; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 224: sun.misc.Unsafe (Bypassing Java Rules) ===\n");

        System.out.println("Unsafe is a hidden API used by Spring, Hibernate, and High-Performance libraries.");
        System.out.println("It allows allocating C++ style memory, bypassing constructors, and ignoring 'private'!\n");

        // 1. You can't just call Unsafe.getUnsafe() because Java blocks it with a SecurityException.
        // We have to use Reflection to steal the instance from inside the class!
        Field unsafeField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        System.out.println("Successfully acquired the Unsafe instance!\n");

        // --- 2. Bypassing the Constructor! ---
        System.out.println("Attempting to create GuardedVault...");
        try {
            new GuardedVault();
        } catch (Exception e) {
            System.out.println("Normal instantiation failed: " + e.getMessage());
        }

        // Unsafe just allocates the memory. It NEVER calls the constructor!
        GuardedVault hackedVault = (GuardedVault) unsafe.allocateInstance(GuardedVault.class);
        System.out.println("Unsafe created the object without triggering the constructor!");
        
        // --- 3. Bypassing Private Variables Instantly ---
        // Steal the memory offset of the 'secretCode' field
        Field secretField = GuardedVault.class.getDeclaredField("secretCode");
        long secretFieldOffset = unsafe.objectFieldOffset(secretField);
        
        System.out.println("\nOriginal Secret Code: " + hackedVault.getSecretCode());
        
        // Overwrite the memory directly!
        unsafe.putInt(hackedVault, secretFieldOffset, 9999);
        
        System.out.println("Hacked Secret Code  : " + hackedVault.getSecretCode());
        System.out.println("\nNote: This is exactly how Java serialization libraries resurrect objects!");
    }
}
