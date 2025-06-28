package com.acm.taller2.controller;


import com.acm.taller2.dto.FacturaDTO;
import com.acm.taller2.mappers.FacturaMapper;
import com.acm.taller2.model.Factura;
import com.acm.taller2.service.FacturaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facturas")
@Validated
public class FacturaController {

    private final FacturaService facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @Operation(
            summary = "Crear una nueva factura",
            description = "Recibe un DTO de Factura en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Factura creada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Factura> saveFactura(
            @Valid @RequestBody FacturaDTO factura
    ) {
        Factura model = FacturaMapper.dtoToModel(factura);
        return ResponseEntity.ok(
                facturaService.saveFactura(model)
        );
    }

    @Operation(
            summary = "Actualizar una factura existente",
            description = "Recibe un DTO de Factura con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Factura actualizada correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna factura con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Factura> updateFactura(
            @Valid @RequestBody FacturaDTO factura
    ) {
        Factura model = FacturaMapper.dtoToModel(factura);
        return ResponseEntity.ok(
                facturaService.updateFactura(model)
        );
    }

    @Operation(
            summary = "Obtener una factura por su ID",
            description = "Retorna los detalles de la Factura identificada por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Factura encontrada y retornada")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna factura con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) {
        return ResponseEntity.ok(
                facturaService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todas las facturas",
            description = "Retorna una lista con todas las Factura almacenadas en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de facturas retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Factura>> getAllFacturas() {
        return ResponseEntity.ok(
                facturaService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar una factura por su ID",
            description = "Elimina la Factura correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Factura eliminada correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ninguna factura con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturaById(@PathVariable Long id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
