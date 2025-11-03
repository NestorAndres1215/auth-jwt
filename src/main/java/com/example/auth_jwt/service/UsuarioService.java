package com.example.auth_jwt.service;

import com.example.auth_jwt.entity.Rol;
import com.example.auth_jwt.entity.Usuario;
import com.example.auth_jwt.repository.RolRepository;
import com.example.auth_jwt.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    // Registrar un usuario con rol
    public Usuario registrarUsuario(String username, String password, String rolNombre) {

        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El usuario '" + username + "' ya está registrado");
        }
        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + rolNombre));

        Usuario usuario = Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .rol(rol)
                .enabled(true)
                .build();
        return usuarioRepository.save(usuario);
    }

    // Buscar usuario por username (para login)
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}