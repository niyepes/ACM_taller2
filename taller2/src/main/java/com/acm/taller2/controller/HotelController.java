package com.acm.taller2.controller;

import com.acm.taller2.model.Hotel;
import com.acm.taller2.persistence.entities.HotelEntity;
import com.acm.taller2.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Crear un nuevo hotel",
            description = "Recibe un objeto HotelEntity en el cuerpo de la petición y lo persiste en la base de datos"
    )
    @ApiResponse(responseCode = "200", description = "Hotel creado correctamente")
    @PostMapping
    public ResponseEntity<HotelEntity> saveHotel(@RequestBody HotelEntity hotelEntity) {
        return ResponseEntity.ok(hotelService.saveHotel(hotelEntity));
    }

    @Operation(
            summary = "Obtener un hotel por su ID",
            description = "Devuelve la información detallada de un hotel existente. Se debe proporcionar el ID en la ruta."
    )
    @ApiResponse(responseCode = "200", description = "Hotel encontrado y retornado")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún hotel con el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        return ResponseEntity.ok(hotelService.findById(id));
    }

    @Operation(
            summary = "Eliminar un hotel por su ID",
            description = "Elimina el hotel identificado por el ID proporcionado en la ruta. " +
                    "Si la operación es exitosa, retorna código 204 (No Content)."
    )
    @ApiResponse(responseCode = "204", description = "Hotel eliminado correctamente")
    @ApiResponse(responseCode = "404", description = "No se encontró ningún hotel con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        hotelService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}