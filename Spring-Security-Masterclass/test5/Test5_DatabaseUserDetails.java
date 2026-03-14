package com.example.security;

import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import java.util.*;

@Entity
class AppUser {
    @Id @GeneratedValue
    private Long id;
    private String username;
    private String password;
    private String role; // e.g., "ROLE_ADMIN"

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
}

interface AppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUsername(String username);
}

@Service
public class Test5_DatabaseUserDetails implements UserDetailsService {

    private final AppUserRepository repo;

    public Test5_DatabaseUserDetails(AppUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = repo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            List.of(new SimpleGrantedAuthority(user.getRole()))
        );
    }
}
