package com.acm.taller2.controller;


import com.acm.taller2.dto.AdministradorDTO;
import com.acm.taller2.mappers.AdministradorMapper;
import com.acm.taller2.model.Administrador;
import com.acm.taller2.persistence.entities.AdministradorEntity;
import com.acm.taller2.service.AdministradorService;
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

    @PostMapping
    public ResponseEntity<AdministradorEntity> saveAdministrador(@Valid @RequestBody AdministradorDTO administrador) {
        return ResponseEntity.ok(administradorService.saveAdministrador(AdministradorMapper.modelToEntity(dtoToModel(administrador))));
    }

    @PutMapping
    public ResponseEntity<Administrador> updateAdministrador(@Valid @RequestBody AdministradorDTO administrador) {
        return ResponseEntity.ok(administradorService.updateAdministrador(AdministradorMapper.dtoToModel(administrador)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrador> getAdministradorById(@PathVariable Long id) {
        return ResponseEntity.ok(administradorService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Administrador>> getAllAdministrators() {
        return ResponseEntity.ok(administradorService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministradorById(@PathVariable Long id) {
        administradorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
