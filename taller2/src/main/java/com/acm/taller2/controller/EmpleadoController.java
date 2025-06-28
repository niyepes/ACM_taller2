package com.acm.taller2.controller;

import com.acm.taller2.dto.EmpleadoDTO;
import com.acm.taller2.mappers.EmpleadoMapper;
import com.acm.taller2.model.Empleado;
import com.acm.taller2.service.EmpleadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleados")
@Validated
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @Operation(
            summary = "Crear un nuevo empleado",
            description = "Recibe un DTO de Empleado en el cuerpo de la petición y lo persiste en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Empleado creado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(
            @Valid @RequestBody EmpleadoDTO empleado
    ) {
        Empleado model = EmpleadoMapper.dtoToModel(empleado);
        return ResponseEntity.ok(
                empleadoService.saveEmpleado(model)
        );
    }

    @Operation(
            summary = "Actualizar un empleado existente",
            description = "Recibe un DTO de Empleado con ID existente y actualiza sus datos en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Empleado actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún empleado con el ID proporcionado")
    @PutMapping
    public ResponseEntity<Empleado> updateEmpleado(
            @Valid @RequestBody EmpleadoDTO empleado
    ) {
        Empleado model = EmpleadoMapper.dtoToModel(empleado);
        return ResponseEntity.ok(
                empleadoService.updateEmpleado(model)
        );
    }

    @Operation(
            summary = "Obtener un empleado por su ID",
            description = "Retorna los datos del Empleado identificado por el ID proporcionado en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Empleado encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún empleado con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        return ResponseEntity.ok(
                empleadoService.findById(id)
        );
    }

    @Operation(
            summary = "Listar todos los empleados",
            description = "Retorna una lista con todos los Empleado almacenados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de empleados retornada correctamente")
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        return ResponseEntity.ok(
                empleadoService.findAll()
        );
    }

    @Operation(
            summary = "Eliminar un empleado por su ID",
            description = "Elimina el Empleado correspondiente al ID proporcionado y retorna HTTP 204 No Content."
    )
    @ApiResponse(responseCode = "204", description = "Empleado eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún empleado con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleadoById(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
