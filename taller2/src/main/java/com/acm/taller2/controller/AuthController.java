package com.acm.taller2.controller;

import com.acm.taller2.dto.UserAuthDTO;
import com.acm.taller2.dto.UsuarioDTO;
import com.acm.taller2.model.Usuario;
import com.acm.taller2.service.UsuarioService;
import com.acm.taller2.utils.JWTUtil;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final JWTUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final UsuarioService usuarioService;
    private final PasswordEncoder passwordEncoder;

    @Operation(
            summary = "User login",
            description = "Authenticate user with username and password, and return a JWT token along with the username."
    )
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserAuthDTO userAuthDto) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userAuthDto.getNombreUsuario(),
                            userAuthDto.getContrasena()
                    )
            );
            User user = (User) authentication.getPrincipal();
            String token = jwtUtil.generateToken(user.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("username", user.getUsername());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid username or password");
        }
    }

    @Operation(
            summary = "User registration",
            description = "Register a new user with the provided details. The password is encoded and the default role 'Cliente' is assigned."
    )
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UsuarioDTO usuarioDto) {
        try {
            usuarioService.saveUsuario(
                    Usuario.builder()
                            .nombreUsuario(usuarioDto.getNombreUsuario())
                            .contrasena(passwordEncoder.encode(usuarioDto.getContrasena()))
                            .rol("Cliente")
                            .build()
            );
            return ResponseEntity.ok("Usuario registrado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
