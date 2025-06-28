package com.acm.taller2.controller;


import com.acm.taller2.dto.FacturaDTO;
import com.acm.taller2.mappers.FacturaMapper;
import com.acm.taller2.model.Factura;
import com.acm.taller2.service.FacturaService;
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

    @PostMapping
    public ResponseEntity<Factura> saveFactura(@Valid @RequestBody FacturaDTO factura) {
        return ResponseEntity.ok(facturaService.saveFactura(FacturaMapper.dtoToModel(factura)));
    }

    @PutMapping
    public ResponseEntity<Factura> updateFactura(@Valid @RequestBody FacturaDTO factura) {
        return ResponseEntity.ok(facturaService.updateFactura(FacturaMapper.dtoToModel(factura)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) {
        return ResponseEntity.ok(facturaService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Factura>> getAllFacturas() {
        return ResponseEntity.ok(facturaService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFacturaById(@PathVariable Long id) {
        facturaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
