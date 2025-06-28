package com.acm.taller2.controller;

import com.acm.taller2.dto.ReservaDTO;
import com.acm.taller2.mappers.ReservaMapper;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.service.ReservaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Validated
public class ReservaController {

    private final ReservaService reservaService;

    @Autowired
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @Operation(
            summary = "Crear una nueva reserva",
            description = "Recibe un DTO de Reserva en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Reserva creada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Reserva> saveReserva(
            @Valid @RequestBody ReservaDTO reserva
    ) {
        Reserva model = ReservaMapper.dtoToModel(reserva);
        return ResponseEntity.ok(
                reservaService.saveReserva(model)
        );
    }

    @Operation(
            summary = "Actualizar una reserva existente",
            description = "Recibe un DTO de Reserva con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Reserva actualizada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna reserva con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Reserva> updateReserva(
            @Valid @RequestBody ReservaDTO reserva
    ) {
        Reserva model = ReservaMapper.dtoToModel(reserva);
        return ResponseEntity.ok(
                reservaService.updateReserva(model)
        );
    }

    @Operation(
            summary = "Obtener una reserva por su ID",
            description = "Retorna los detalles de la Reserva identificada por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Reserva encontrada y retornada")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna reserva con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(
                reservaService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todas las reservas",
            description = "Retorna una lista con todas las Reserva almacenadas en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de reservas retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        return ResponseEntity.ok(
                reservaService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar una reserva por su ID",
            description = "Elimina la Reserva correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Reserva eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna reserva con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservaById(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
