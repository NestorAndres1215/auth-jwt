package com.example.auth_jwt.service;

import com.example.auth_jwt.dto.RegisterRequest;
import com.example.auth_jwt.entity.Rol;
import com.example.auth_jwt.entity.Usuario;
import com.example.auth_jwt.repository.RolRepository;
import com.example.auth_jwt.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;
    private final PasswordEncoder passwordEncoder;


    public Usuario registrarUsuario(RegisterRequest registerRequest) {

        String username = registerRequest.getUsername();
        String password = registerRequest.getPassword();
        String rolNombre = registerRequest.getRol();

        if (usuarioRepository.existsByUsername(username)) {
            throw new RuntimeException("El usuario '" + username + "' ya está registrado");
        }

        Rol rol = rolRepository.findByNombre(rolNombre)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado: " + rolNombre));

        Usuario usuario = Usuario.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .nombre(registerRequest.getNombre())
                .apellido(registerRequest.getApellido())
                .email(registerRequest.getEmail())
                .telefono(registerRequest.getTelefono())
                .fechaRegistro(LocalDateTime.now())
                .enabled(true)
                .rol(rol)
                .build();

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }
}