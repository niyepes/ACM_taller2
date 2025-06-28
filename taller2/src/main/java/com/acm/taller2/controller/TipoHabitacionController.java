package com.acm.taller2.controller;

import com.acm.taller2.dto.TipoHabitacionDTO;
import com.acm.taller2.mappers.TipoHabitacionMapper;
import com.acm.taller2.model.TipoHabitacion;
import com.acm.taller2.service.TipoHabitacionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoHabitacion")
@Validated
public class TipoHabitacionController {

    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @Operation(
            summary = "Crear un nuevo tipo de habitación",
            description = "Recibe un DTO de TipoHabitacion en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Tipo de habitación creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<TipoHabitacion> saveTipoHabitacion(
            @Valid @RequestBody TipoHabitacionDTO tipoHabitacion
    ) {
        TipoHabitacion model = TipoHabitacionMapper.dtoToModel(tipoHabitacion);
        return ResponseEntity.ok(
                tipoHabitacionService.saveTipoHabitacion(model)
        );
    }

    @Operation(
            summary = "Actualizar un tipo de habitación existente",
            description = "Recibe un DTO de TipoHabitacion con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Tipo de habitación actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún tipo de habitación con el ID proporcionado")
    @PutMapping
    public ResponseEntity<TipoHabitacion> updateTipoHabitacion(
            @Valid @RequestBody TipoHabitacionDTO tipoHabitacion
    ) {
        TipoHabitacion model = TipoHabitacionMapper.dtoToModel(tipoHabitacion);
        return ResponseEntity.ok(
                tipoHabitacionService.updateTipoHabitacion(model)
        );
    }

    @Operation(
            summary = "Obtener un tipo de habitación por su ID",
            description = "Retorna los detalles del TipoHabitacion identificado por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Tipo de habitación encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún tipo de habitación con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> getTipoHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(
                tipoHabitacionService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todos los tipos de habitación",
            description = "Retorna una lista con todos los TipoHabitacion almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de tipos de habitación retornada correctamente")
    @GetMapping
    public ResponseEntity<List<TipoHabitacion>> getAllTipoHabitacions() {
        return ResponseEntity.ok(
                tipoHabitacionService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar un tipo de habitación por su ID",
            description = "Elimina el TipoHabitacion correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Tipo de habitación eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún tipo de habitación con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoHabitacionById(@PathVariable Long id) {
        tipoHabitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
