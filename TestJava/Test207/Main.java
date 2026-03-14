package TestJava.Test207;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;

// Must implement java.io.Serializable!
class GameSave implements Serializable {
    // Recommended to provide a version ID so class changes don't break old saves
    private static final long serialVersionUID = 1L;

    public String playerName;
    public int level;
    
    // 'transient' means this will NOT be saved to disk!
    public transient String currentSessionToken; 
    
    public GameSave(String player, int level, String token) {
        this.playerName = player;
        this.level = level;
        this.currentSessionToken = token;
    }
    
    @Override
    public String toString() {
        return "GameSave{playerName='" + playerName + "', level=" + level + ", token='" + currentSessionToken + "'}";
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("=== Test 207: Java Serialization & Deserialization ===\n");

        System.out.println("Serialization converts Java Objects into a binary byte stream so they");
        System.out.println("can be written to disk, sent over network, or saved in a DB.\n");

        GameSave originalState = new GameSave("Hero99", 50, "SECURE_XYZ_123");
        System.out.println("1. Original Object before saving: " + originalState);
        System.out.println("Notice the session token exists.\n");
        
        String filename = "savegame.dat";

        // --- Serialization ---
        System.out.println("2. Serializing object to '" + filename + "'...");
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            
            oos.writeObject(originalState);
            System.out.println("Success! Java implicitly wrote the object graph to disk.");
        }

        // --- Deserialization ---
        System.out.println("\n3. Deserializing object from '" + filename + "'...");
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            // Reads the binary and resurrects the object!
            GameSave loadedState = (GameSave) ois.readObject();
            
            System.out.println("Success! Object restored.");
            System.out.println("4. Loaded Object: " + loadedState);
            System.out.println("Notice the session token is NULL because we marked it 'transient'!");
        }
        
        // Cleanup
        new java.io.File(filename).delete();
    }
}
