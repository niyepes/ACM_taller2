package com.acm.taller2.controller;

import com.acm.taller2.dto.UsuarioDTO;
import com.acm.taller2.mappers.UsuarioMapper;
import com.acm.taller2.model.Usuario;
import com.acm.taller2.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Registrar un nuevo usuario",
            description = "Recibe un DTO de Usuario en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Usuario registrado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(
            @Valid @RequestBody UsuarioDTO usuario
    ) {
        Usuario model = UsuarioMapper.dtoToModel(usuario);
        return ResponseEntity.ok(
                usuarioService.saveUsuario(model)
        );
    }

    @Operation(
            summary = "Actualizar un usuario existente",
            description = "Recibe un DTO de Usuario con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Usuario actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún usuario con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Usuario> updateUsuario(
            @Valid @RequestBody UsuarioDTO usuario
    ) {
        Usuario model = UsuarioMapper.dtoToModel(usuario);
        return ResponseEntity.ok(
                usuarioService.updateUsuario(model)
        );
    }

    @Operation(
            summary = "Obtener un usuario por su ID",
            description = "Retorna los detalles del Usuario identificado por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Usuario encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún usuario con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return ResponseEntity.ok(
                usuarioService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todos los usuarios",
            description = "Retorna una lista con todos los Usuarios almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de usuarios retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(
                usuarioService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar un usuario por su ID",
            description = "Elimina el Usuario correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Usuario eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún usuario con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
