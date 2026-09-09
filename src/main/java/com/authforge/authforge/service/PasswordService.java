package com.authforge.authforge.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
  private final PasswordEncoder passwordEncoder;

    public PasswordService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String hash(String password){
        return passwordEncoder.encode(password);
    }

    public boolean matches(String password, String passwordHash) {
        return passwordEncoder.matches(password, passwordHash);
    }
}
