package com.acm.taller2.controller;

import com.acm.taller2.dto.AdministradorGeneralDTO;
import com.acm.taller2.mappers.AdministradorGeneralMapper;
import com.acm.taller2.model.AdministradorGeneral;
import com.acm.taller2.service.AdministradorGeneralService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administradorGeneral")
@Validated
public class AdministradorGeneralController {

    private final AdministradorGeneralService administradorGeneralService;

    @Autowired
    public AdministradorGeneralController(AdministradorGeneralService administradorGeneralService) {
        this.administradorGeneralService = administradorGeneralService;
    }

    @Operation(
            summary = "Crear un administrador general",
            description = "Recibe un DTO de AdministradorGeneral en el cuerpo y lo guarda en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Administrador general creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<AdministradorGeneral> saveAdministradorGeneral(
            @Valid @RequestBody AdministradorGeneralDTO administradorGeneral
    ) {
        AdministradorGeneral model = AdministradorGeneralMapper.dtoToModel(administradorGeneral);
        return ResponseEntity.ok(
                administradorGeneralService.saveAdministradorGeneral(model)
        );
    }

    @Operation(
            summary = "Actualizar un administrador general",
            description = "Recibe un DTO con ID existente y actualiza el AdministradorGeneral correspondiente."
    )
    @ApiResponse(responseCode = "200", description = "Administrador general actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún AdministradorGeneral con el ID proporcionado")
    @PutMapping
    public ResponseEntity<AdministradorGeneral> updateAdministradorGeneral(
            @Valid @RequestBody AdministradorGeneralDTO administradorGeneral
    ) {
        AdministradorGeneral model = AdministradorGeneralMapper.dtoToModel(administradorGeneral);
        return ResponseEntity.ok(
                administradorGeneralService.updateAdministradorGeneral(model)
        );
    }

    @Operation(
            summary = "Obtener un administrador general por ID",
            description = "Retorna el AdministradorGeneral correspondiente al ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Administrador general encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún AdministradorGeneral con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<AdministradorGeneral> getAdministradorGeneralById(@PathVariable Long id) {
        return ResponseEntity.ok(
                administradorGeneralService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todos los administradores generales",
            description = "Retorna una lista con todos los AdministradorGeneral almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de administradores generales retornada correctamente")
    @GetMapping
    public ResponseEntity<List<AdministradorGeneral>> getAllAdministradorGenerals() {
        return ResponseEntity.ok(
                administradorGeneralService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar un administrador general por ID",
            description = "Elimina el AdministradorGeneral correspondiente al ID proporcionado y retorna 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Administrador general eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún AdministradorGeneral con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministradorGeneralById(@PathVariable Long id) {
        administradorGeneralService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
