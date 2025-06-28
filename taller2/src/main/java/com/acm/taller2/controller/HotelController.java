package com.acm.taller2.controller;

import com.acm.taller2.model.Hotel;
import com.acm.taller2.persistence.entities.HotelEntity;
import com.acm.taller2.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hoteles")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    //TODO: Agregar validacion para códigos de error
    @PostMapping()
    public ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelEntity hotelEntity){
        return ResponseEntity.ok(hotelService.saveHotel(hotelEntity));
    }

    @Operation(summary="Devuelve la información de un hotel a partir de su id", description = "El siguiente endpoint retorna la informacion de un hotel se requiere el ID para realizar la busqueda")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById (@PathVariable Long id){
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel (@PathVariable Long id){
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
