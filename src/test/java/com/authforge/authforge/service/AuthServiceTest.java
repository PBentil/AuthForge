package com.authforge.authforge.service;

import com.authforge.authforge.dto.RegisterRequest;
import com.authforge.authforge.dto.UserResponse;
import com.authforge.authforge.model.User;
import com.authforge.authforge.model.UserStatus;
import com.authforge.authforge.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuthServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordService passwordService;

    private AuthService authService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        authService = new AuthService(
                userRepository,
                passwordService
        );
    }

    @Test
    void shouldRegisterUserSuccessfully() {

        RegisterRequest request = new RegisterRequest();

        request.setEmail("alice@example.com");
        request.setName("Alice Osei");
        request.setPassword("Password123");

        when(userRepository.existsByEmail("alice@example.com"))
                .thenReturn(false);

        when(passwordService.hash("Password123"))
                .thenReturn("hashed-password");

        when(userRepository.save(any(User.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        UserResponse response = authService.register(request);

        assertEquals("alice@example.com", response.getEmail());
        assertEquals("Alice Osei", response.getName());
        assertEquals(
                UserStatus.PENDING_VERIFICATION,
                response.getStatus()
        );

        verify(passwordService).hash("Password123");

        verify(userRepository).save(any(User.class));
    }
}
