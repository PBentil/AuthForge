package com.authforge.authforge.dto;

public class LoginResponse {
    private String Message;
    private String token;

    public LoginResponse(String message, String token) {
        Message = message;
        this.token = token;
    }

    public String getMessage() {
        return Message;
    }

    public String getToken() {
        return token;
    }
}
