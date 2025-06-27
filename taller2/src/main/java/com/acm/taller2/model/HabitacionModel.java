package com.acm.taller2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitacionModel {
    private Long id;
    private Integer numeroHabitacion;
    private Integer precioDia;
    private Boolean disponible;
    private Long hotelID;
    private Long tipoHabitacionID;
}
