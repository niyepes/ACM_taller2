package com.acm.taller2.dto;

import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class FacturaDTO {
    @Min(value = 1, message = "El id debe ser mayor a 0")
    private Long id;

    private Long idreserva;

    private Long idpago;

    private Integer valorTotal;

    private Timestamp fechaEmision;
}
