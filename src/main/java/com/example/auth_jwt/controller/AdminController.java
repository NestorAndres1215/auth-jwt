package com.example.auth_jwt.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public String verDashboard() {
        return "Bienvenido ADMIN, esta es tu zona de administración.";
    }

    @GetMapping("/usuarios")
    public String gestionarUsuarios() {
        return "Aquí puedes gestionar todos los usuarios de la aplicación.";
    }
}