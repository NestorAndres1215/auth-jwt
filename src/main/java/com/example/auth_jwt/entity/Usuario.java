package com.example.auth_jwt.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    // ====== Identificador ======
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ====== Credenciales ======
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    // ====== Información personal ======
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    // ====== Estado y registro ======
    private LocalDateTime fechaRegistro;
    private boolean enabled = true;

    // ====== Relaciones ======
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id", nullable = false)
    private Rol rol;
}
