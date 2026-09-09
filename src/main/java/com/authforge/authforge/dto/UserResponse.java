package com.authforge.authforge.dto;

import com.authforge.authforge.model.UserStatus;

import java.time.OffsetDateTime;
import java.util.UUID;

public class UserResponse {

    private UUID id;
    private String email;
    private String name;
    private UserStatus status;
    private OffsetDateTime createdAt;

    public UserResponse() {
    }

    public UserResponse(UUID id, String email, String name, UserStatus status, OffsetDateTime createdAt) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public UserStatus getStatus() {
        return status;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
}
