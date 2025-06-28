package com.acm.taller2.controller;

import com.acm.taller2.dto.UsuarioDTO;
import com.acm.taller2.mappers.UsuarioMapper;
import com.acm.taller2.model.Usuario;
import com.acm.taller2.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@Validated
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.saveUsuario(UsuarioMapper.dtoToModel(usuario)));
    }

    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(@Valid @RequestBody UsuarioDTO usuario) {
        return ResponseEntity.ok(usuarioService.updateUsuario(UsuarioMapper.dtoToModel(usuario)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
