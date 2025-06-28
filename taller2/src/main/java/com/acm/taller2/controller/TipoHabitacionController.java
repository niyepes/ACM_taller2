package com.acm.taller2.controller;

import com.acm.taller2.dto.TipoHabitacionDTO;
import com.acm.taller2.mappers.TipoHabitacionMapper;
import com.acm.taller2.model.TipoHabitacion;
import com.acm.taller2.service.TipoHabitacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipoHabitacion")
@Validated
public class TipoHabitacionController {
    private final TipoHabitacionService tipoHabitacionService;

    @Autowired
    public TipoHabitacionController(TipoHabitacionService tipoHabitacionService) {
        this.tipoHabitacionService = tipoHabitacionService;
    }

    @PostMapping
    public ResponseEntity<TipoHabitacion> saveTipoHabitacion(@Valid @RequestBody TipoHabitacionDTO tipoHabitacion) {
        return ResponseEntity.ok(tipoHabitacionService.saveTipoHabitacion(TipoHabitacionMapper.dtoToModel(tipoHabitacion)));
    }

    @PutMapping
    public ResponseEntity<TipoHabitacion> updateTipoHabitacion(@Valid @RequestBody TipoHabitacionDTO tipoHabitacion) {
        return ResponseEntity.ok(tipoHabitacionService.updateTipoHabitacion(TipoHabitacionMapper.dtoToModel(tipoHabitacion)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoHabitacion> getTipoHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoHabitacionService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<TipoHabitacion>> getAllTipoHabitacions() {
        return ResponseEntity.ok(tipoHabitacionService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipoHabitacionById(@PathVariable Long id) {
        tipoHabitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
