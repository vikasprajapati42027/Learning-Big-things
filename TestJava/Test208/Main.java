package TestJava.Test208;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

// Instead of Serializable, we use Externalizable.
// This gives us 100% control over WHAT and HOW things are converted to bytes.
// It is significantly faster than standard Reflection-based Serializable!
class HighPerformanceUser implements Externalizable {
    private int id;
    private String name;
    
    // Externalizable requires a public no-arg constructor!
    public HighPerformanceUser() {}

    public HighPerformanceUser(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // WE define how it writes to the stream (No slow reflection)
    @Override
    public void writeExternal(ObjectOutput out) throws java.io.IOException {
        out.writeInt(id);
        
        // We can do custom compressions/encryption here!
        out.writeUTF(new StringBuilder(name).reverse().toString()); // Silly encryption!
    }

    // WE define how it reads from the stream
    @Override
    public void readExternal(ObjectInput in) throws java.io.IOException, ClassNotFoundException {
        this.id = in.readInt();
        
        // Reverse it back
        this.name = new StringBuilder(in.readUTF()).reverse().toString();
    }
    
    @Override
    public String toString() { return "User{" + id + ", '" + name + "'}"; }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 208: Custom Serialization (Externalizable) ===\n");

        System.out.println("java.io.Serializable uses Reflection, which is slow and bloated.");
        System.out.println("java.io.Externalizable forces you to manually write/read variables,");
        System.out.println("making it much faster and allowing custom encryption/compression!\n");

        HighPerformanceUser user = new HighPerformanceUser(42, "Confidential");
        System.out.println("Original Object: " + user);

        String filename = "external_user.dat";

        // Write
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(user); // Triggers our writeExternal() method!
        }

        // Read
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            HighPerformanceUser resurrected = (HighPerformanceUser) ois.readObject(); // Triggers readExternal()!
            System.out.println("Loaded Object: " + resurrected);
        }
        
        // Cleanup
        new java.io.File(filename).delete();
    }
}
