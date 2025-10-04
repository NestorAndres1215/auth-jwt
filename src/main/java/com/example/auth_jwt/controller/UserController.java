package com.example.auth_jwt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/perfil")
    public String verPerfil() {
        return "Bienvenido usuario, esta es tu información de perfil.";
    }

    @GetMapping("/datos")
    public String verDatos() {
        return "Aquí puedes ver tus datos como USER o ADMIN.";
    }
}