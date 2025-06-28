package com.acm.taller2.controller;

import com.acm.taller2.dto.HabitacionDTO;
import com.acm.taller2.model.Habitacion;
import com.acm.taller2.persistence.entities.HabitacionEntity;
import com.acm.taller2.service.HabitacionService;
import com.acm.taller2.mappers.HabitacionMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acm.taller2.mappers.HabitacionMapper.dtoToModel;

@RestController
@RequestMapping("/habitaciones")
@Validated
public class HabitacionController {

    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @Operation(
            summary = "Crear una nueva habitación",
            description = "Recibe un DTO de Habitación en el cuerpo de la petición, lo mapea a entidad y lo guarda en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Habitación creada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<HabitacionEntity> saveHabitacion(
            @Valid @RequestBody HabitacionDTO habitacion
    ) {
        HabitacionEntity entidad = HabitacionMapper.modelToEntity(
                HabitacionMapper.dtoToModel(habitacion)
        );
        return ResponseEntity.ok(
                habitacionService.saveHabitacion(entidad)
        );
    }

    @Operation(
            summary = "Actualizar una habitación existente",
            description = "Recibe un DTO de Habitación con ID existente, lo mapea a entidad y actualiza sus datos."
    )
    @ApiResponse(responseCode = "200", description = "Habitación actualizada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna habitación con el ID proporcionado")
    @PutMapping
    public ResponseEntity<HabitacionEntity> updateHabitacion(
            @Valid @RequestBody HabitacionDTO habitacion
    ) {
        HabitacionEntity entidad = HabitacionMapper.modelToEntity(
                HabitacionMapper.dtoToModel(habitacion)
        );
        return ResponseEntity.ok(
                habitacionService.updateHabitacion(entidad)
        );
    }

    @Operation(
            summary = "Obtener una habitación por su ID",
            description = "Retorna la entidad Habitacion correspondiente al ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Habitación encontrada y retornada")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna habitación con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<HabitacionEntity> getHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(
                habitacionService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todas las habitaciones",
            description = "Retorna una lista con todas las HabitacionEntity almacenadas en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de habitaciones retornada correctamente")
    @GetMapping
    public ResponseEntity<List<HabitacionEntity>> getAllHabitacions() {
        return ResponseEntity.ok(
                habitacionService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar una habitación por su ID",
            description = "Elimina la HabitacionEntity correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Habitación eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna habitación con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacionById(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
