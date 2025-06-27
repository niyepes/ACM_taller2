package com.acm.taller2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaModel {
    private Long id;
    private Timestamp fechaInicio;
    private Timestamp fechaFinal;
    private Integer cantidadDias;
    private Boolean estado;
    private Timestamp fechaReserva;
    private Long habitacionID;
    private Long clienteID;
}
