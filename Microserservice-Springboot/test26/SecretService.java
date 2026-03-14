package com.example.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SecretService {

    @Value("${my.db.password:default_pass}")
    private String dbPassword;

    public String fetchSecret() {
        // In a real app, this value would come from HashiCorp Vault
        return "Secret fetched from Vault: " + dbPassword;
    }
}
