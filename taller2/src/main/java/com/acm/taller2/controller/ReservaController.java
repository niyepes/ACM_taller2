package com.acm.taller2.controller;

import com.acm.taller2.dto.ReservaDTO;
import com.acm.taller2.mappers.ReservaMapper;
import com.acm.taller2.model.Reserva;
import com.acm.taller2.service.ReservaService;
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

    @PostMapping
    public ResponseEntity<Reserva> saveReserva(@Valid @RequestBody ReservaDTO reserva) {
        return ResponseEntity.ok(reservaService.saveReserva(ReservaMapper.dtoToModel(reserva)));
    }

    @PutMapping
    public ResponseEntity<Reserva> updateReserva(@Valid @RequestBody ReservaDTO reserva) {
        return ResponseEntity.ok(reservaService.updateReserva(ReservaMapper.dtoToModel(reserva)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Reserva>> getAllReservas() {
        return ResponseEntity.ok(reservaService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservaById(@PathVariable Long id) {
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
