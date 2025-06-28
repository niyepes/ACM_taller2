package com.acm.taller2.controller;

import com.acm.taller2.dto.HabitacionDTO;
import com.acm.taller2.model.Habitacion;
import com.acm.taller2.persistence.entities.HabitacionEntity;
import com.acm.taller2.service.HabitacionService;
import com.acm.taller2.mappers.HabitacionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.acm.taller2.mappers.HabitacionMapper.dtoToModel;

@RestController
@RequestMapping("/habitaciones")
@Validated
public class HabitacionController {
    private final HabitacionService habitacionService;

    @Autowired
    public HabitacionController(HabitacionService habitacionService) {
        this.habitacionService = habitacionService;
    }

    @PostMapping
    public ResponseEntity<HabitacionEntity> saveHabitacion(@Valid @RequestBody HabitacionDTO habitacion) {
        return ResponseEntity.ok(habitacionService.saveHabitacion(HabitacionMapper.modelToEntity(dtoToModel(habitacion))));
    }

    @PutMapping
    public ResponseEntity<HabitacionEntity> updateHabitacion(@Valid @RequestBody HabitacionDTO habitacion) {
        return ResponseEntity.ok(habitacionService.updateHabitacion(HabitacionMapper.modelToEntity(HabitacionMapper.dtoToModel(habitacion))));
    }

    @GetMapping("/{id}")
    public ResponseEntity<HabitacionEntity> getHabitacionById(@PathVariable Long id) {
        return ResponseEntity.ok(habitacionService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<List<HabitacionEntity>> getAllHabitacions() {
        return ResponseEntity.ok(habitacionService.findAll());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacionById(@PathVariable Long id) {
        habitacionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
