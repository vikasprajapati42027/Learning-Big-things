package com.example.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Test 8: Password Security — Hashing, Salting, Strength
public class Test8_PasswordSecurity {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12); // strength 12

        String rawPassword = "MyPassword@123";

        // Hash the password (always different even for same input due to random salt)
        String hash1 = encoder.encode(rawPassword);
        String hash2 = encoder.encode(rawPassword);

        System.out.println("Hash 1: " + hash1);
        System.out.println("Hash 2: " + hash2);
        System.out.println("Same? " + hash1.equals(hash2)); // false! Different salts

        // Verify password against hash (what Spring does at login)
        boolean isMatch = encoder.matches(rawPassword, hash1);
        System.out.println("Password matches hash1? " + isMatch); // true!

        System.out.println("\n--- Why weak passwords are dangerous ---");
        System.out.println("'password' → attacker has this hash precomputed in rainbow tables");
        System.out.println("BCrypt with salt makes rainbow tables useless!");
    }
}
