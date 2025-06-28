package com.acm.taller2.controller;

import com.acm.taller2.dto.PagoDTO;
import com.acm.taller2.mappers.PagoMapper;
import com.acm.taller2.model.Pago;
import com.acm.taller2.service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@Validated
public class PagoController {

    private final PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @Operation(
            summary = "Registrar un nuevo pago",
            description = "Recibe un DTO de Pago en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Pago registrado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Pago> savePago(
            @Valid @RequestBody PagoDTO pago
    ) {
        Pago model = PagoMapper.dtoToModel(pago);
        return ResponseEntity.ok(
                pagoService.savePago(model)
        );
    }

    @Operation(
            summary = "Actualizar un pago existente",
            description = "Recibe un DTO de Pago con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Pago actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún pago con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Pago> updatePago(
            @Valid @RequestBody PagoDTO pago
    ) {
        Pago model = PagoMapper.dtoToModel(pago);
        return ResponseEntity.ok(
                pagoService.updatePago(model)
        );
    }

    @Operation(
            summary = "Obtener un pago por su ID",
            description = "Retorna los detalles del Pago identificado por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Pago encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún pago con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        return ResponseEntity.ok(
                pagoService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todos los pagos",
            description = "Retorna una lista con todos los Pagos almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de pagos retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Pago>> getAllPagos() {
        return ResponseEntity.ok(
                pagoService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar un pago por su ID",
            description = "Elimina el Pago correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Pago eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún pago con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagoById(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
