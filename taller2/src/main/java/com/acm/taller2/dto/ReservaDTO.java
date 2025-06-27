package com.acm.taller2.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class ReservaDTO {
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Long id;

    private Timestamp fechaInicio;

    private Timestamp fechaFinal;

    private Integer cantidadDias;

    private Boolean estado;

    private Timestamp fechaReserva;

    private Long idhabitacion;

    private Long idcliente;
}
