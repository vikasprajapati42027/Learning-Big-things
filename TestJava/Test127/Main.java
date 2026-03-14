package TestJava.Test127;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.VarHandle;

class SecretVault {
    private String passcode = "12345";
    
    private void unlock(String code) {
        if (passcode.equals(code)) {
            System.out.println("Vault unlocked!");
        } else {
            System.out.println("Wrong code!");
        }
    }
}

public class Main {
    public static void main(String[] args) throws Throwable {
        System.out.println("=== MethodHandles & VarHandles (Faster Reflection) ===\n");

        // Standard java.lang.reflect is slow and bypasses JVM optimizations.
        // java.lang.invoke.MethodHandle (Java 7+) and VarHandle (Java 9+) are MUCH faster 
        // direct JVM hooks (like 'function pointers' in C).

        SecretVault vault = new SecretVault();

        // 1. Get a Lookup object that has full permission
        // Using privateLookupIn allows us to bypass 'private' access controls entirely!
        MethodHandles.Lookup lookup = MethodHandles.privateLookupIn(SecretVault.class, MethodHandles.lookup());

        System.out.println("--- Using VarHandle to read/write a Private Variable ---");
        
        // Find the private 'passcode' variable (of type String)
        VarHandle passcodeHandle = lookup.findVarHandle(SecretVault.class, "passcode", String.class);
        
        // Read it
        String secret = (String) passcodeHandle.get(vault);
        System.out.println("Hacked Passcode read directly: " + secret);
        
        // Change it!
        passcodeHandle.set(vault, "99999");
        System.out.println("Passcode changed via VarHandle!\n");

        System.out.println("--- Using MethodHandle to call a Private Method ---");
        
        // MethodType outlines the signature: Returns void, takes String as argument
        MethodType mt = MethodType.methodType(void.class, String.class);
        
        // Find the private method
        MethodHandle unlockHandle = lookup.findSpecial(SecretVault.class, "unlock", mt, SecretVault.class);
        
        // Invoke it! (invokeExact is strictly typed and extremely fast)
        System.out.println("Attempting to unlock with old code [12345]:");
        unlockHandle.invokeExact(vault, "12345");
        
        System.out.println("Attempting to unlock with new code [99999]:");
        unlockHandle.invokeExact(vault, "99999");
    }
}
