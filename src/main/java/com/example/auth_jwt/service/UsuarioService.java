package com.example.auth_jwt.service;

import com.example.auth_jwt.entity.Rol;
import com.example.auth_jwt.entity.Usuario;
import com.example.auth_jwt.repository.RolRepository;
import com.example.auth_jwt.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository,
                          RolRepository rolRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.rolRepository = rolRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Registrar un usuario con rol
    public Usuario registrarUsuario(String username, String password, String rolNombre) {

        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El usuario '" + username + "' ya está registrado");
        }
        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + rolNombre));

        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password)); // Se encripta la contraseña
        usuario.setRol(rol);
        usuario.setEnabled(true);

        return usuarioRepository.save(usuario);
    }

    // Buscar usuario por username (para login)
    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}