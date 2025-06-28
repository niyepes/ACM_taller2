package com.acm.taller2.controller;


import com.acm.taller2.dto.AdministradorDTO;
import com.acm.taller2.mappers.AdministradorMapper;
import com.acm.taller2.model.Administrador;
import com.acm.taller2.persistence.entities.AdministradorEntity;
import com.acm.taller2.service.AdministradorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acm.taller2.mappers.AdministradorMapper.dtoToModel;

@RestController
@RequestMapping("/administradores")
@Validated
public class AdministradorController {

    private final AdministradorService administradorService;

    @Autowired
    public AdministradorController(AdministradorService administradorService) {
        this.administradorService = administradorService;
    }

    @Operation(
            summary = "Crear un nuevo administrador",
            description = "Recibe un DTO de administrador en el cuerpo de la petición y lo persiste como entidad en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Administrador creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<AdministradorEntity> saveAdministrador(
            @Valid @RequestBody AdministradorDTO administrador
    ) {
        AdministradorEntity entidad = AdministradorMapper.modelToEntity(
                AdministradorMapper.dtoToModel(administrador)
        );
        return ResponseEntity.ok(administradorService.saveAdministrador(entidad));
    }

    @Operation(
            summary = "Actualizar un administrador existente",
            description = "Recibe un DTO de administrador con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Administrador actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró un administrador con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Administrador> updateAdministrador(
            @Valid @RequestBody AdministradorDTO administrador
    ) {
        Administrador modelo = AdministradorMapper.dtoToModel(administrador);
        return ResponseEntity.ok(administradorService.updateAdministrador(modelo));
    }

    @Operation(
            summary = "Obtener un administrador por su ID",
            description = "Devuelve los detalles de un administrador existente. Se debe proporcionar el ID como parte de la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Administrador encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún administrador con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        Administrador admin = administradorService.findById(id);
        return ResponseEntity.ok(admin);
    }

    @Operation(
            summary = "Listar todos los administradores",
            description = "Retorna una lista con todos los administradores registrados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de administradores retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Administrador>> getAllAdministrators() {
        List<Administrador> lista = administradorService.findAll();
        return ResponseEntity.ok(lista);
    }

    @Operation(
            summary = "Eliminar un administrador por su ID",
            description = "Elimina al administrador identificado por el ID proporcionado en la ruta. Retorna HTTP 204 cuando la operación es exitosa."
    )
    @ApiResponse(responseCode = "204", description = "Administrador eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún administrador con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministradorById(@PathVariable Long id) {
        administradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
