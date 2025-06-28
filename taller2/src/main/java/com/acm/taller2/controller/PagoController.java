package com.acm.taller2.controller;

import com.acm.taller2.dto.PagoDTO;
import com.acm.taller2.mappers.PagoMapper;
import com.acm.taller2.model.Pago;
import com.acm.taller2.service.PagoService;
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

    @PostMapping
    public ResponseEntity<Pago> savePago(@Valid @RequestBody PagoDTO pago) {
        return ResponseEntity.ok(pagoService.savePago(PagoMapper.dtoToModel(pago)));
    }

    @PutMapping
    public ResponseEntity<Pago> updatePago(@Valid @RequestBody PagoDTO pago) {
        return ResponseEntity.ok(pagoService.updatePago(PagoMapper.dtoToModel(pago)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pago> getPagoById(@PathVariable Long id) {
        return ResponseEntity.ok(pagoService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Pago>> getAllPagos() {
        return ResponseEntity.ok(pagoService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePagoById(@PathVariable Long id) {
        pagoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
