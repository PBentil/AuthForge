package com.authforge.authforge.service;

import com.authforge.authforge.dto.RegisterRequest;
import com.authforge.authforge.dto.UserResponse;
import com.authforge.authforge.exception.AuthException;
import com.authforge.authforge.model.User;
import com.authforge.authforge.model.UserStatus;
import com.authforge.authforge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    public AuthService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    public UserResponse register(RegisterRequest request){
        if(userRepository.existsByEmail(request.getEmail())) {
            throw new AuthException("Email already is use");
        }

        String passwordHash = passwordService.hash(request.getPassword());

        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswordHash(passwordHash);
        user.setStatus(UserStatus.PENDING_VERIFICATION);
        user.setFailedLogins(0);
        OffsetDateTime now = OffsetDateTime.now();
        user.setCreatedAt(now);
        user.setUpdatedAt(now);

        User savedUser = userRepository.save(user);

        return new UserResponse(
            savedUser.getId(),
            savedUser.getEmail(),
            savedUser.getName(),
            savedUser.getStatus(),
            savedUser.getCreatedAt()
        );
    }
}
