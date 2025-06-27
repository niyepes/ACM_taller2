package com.acm.taller2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipoHabitacionModel {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Long hotelID;
}