package com.authforge.authforge.dto;

public class LoginResponse {
    private String Message;

    public LoginResponse(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
