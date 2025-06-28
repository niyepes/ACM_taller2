package com.acm.taller2.controller;

import com.acm.taller2.dto.EmpleadoDTO;
import com.acm.taller2.mappers.EmpleadoMapper;
import com.acm.taller2.model.Empleado;
import com.acm.taller2.service.EmpleadoService;
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

    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@Valid @RequestBody EmpleadoDTO empleado) {
        return ResponseEntity.ok(empleadoService.saveEmpleado(EmpleadoMapper.dtoToModel(empleado)));
    }

    @PutMapping
    public ResponseEntity<Empleado> updateEmpleado(@Valid @RequestBody EmpleadoDTO empleado) {
        return ResponseEntity.ok(empleadoService.updateEmpleado(EmpleadoMapper.dtoToModel(empleado)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) {
        return ResponseEntity.ok(empleadoService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        return ResponseEntity.ok(empleadoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleadoById(@PathVariable Long id) {
        empleadoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
