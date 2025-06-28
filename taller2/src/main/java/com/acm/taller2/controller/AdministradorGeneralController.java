package com.acm.taller2.controller;

import com.acm.taller2.dto.AdministradorGeneralDTO;
import com.acm.taller2.mappers.AdministradorGeneralMapper;
import com.acm.taller2.model.AdministradorGeneral;
import com.acm.taller2.service.AdministradorGeneralService;
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

    @PostMapping
    public ResponseEntity<AdministradorGeneral> saveAdministradorGeneral(@Valid @RequestBody AdministradorGeneralDTO administradorGeneral) {
        return ResponseEntity.ok(administradorGeneralService.saveAdministradorGeneral(AdministradorGeneralMapper.dtoToModel(administradorGeneral)));
    }

    @PutMapping
    public ResponseEntity<AdministradorGeneral> updateAdministradorGeneral(@Valid @RequestBody AdministradorGeneralDTO administradorGeneral) {
        return ResponseEntity.ok(administradorGeneralService.updateAdministradorGeneral(AdministradorGeneralMapper.dtoToModel(administradorGeneral)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdministradorGeneral> getAdministradorGeneralById(@PathVariable Long id) {
        return ResponseEntity.ok(administradorGeneralService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<AdministradorGeneral>> getAllAdministradorGenerals() {
        return ResponseEntity.ok(administradorGeneralService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministradorGeneralById(@PathVariable Long id) {
        administradorGeneralService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
