package com.example.auth_jwt.dto;

import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String rol; // ROLE_USER o ROLE_ADMIN
}